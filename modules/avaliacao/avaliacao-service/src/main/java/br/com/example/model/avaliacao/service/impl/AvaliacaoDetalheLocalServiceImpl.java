/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.impl;

import br.com.example.model.avaliacao.enums.DesempenhoEnum;
import br.com.example.model.avaliacao.enums.TipoAvaliadorEnum;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.notification.EmailNotificationUtil;
import br.com.example.model.avaliacao.permission.AvaliacaoPermissionChecker;
import br.com.example.model.avaliacao.service.base.AvaliacaoDetalheLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=br.com.example.model.avaliacao.model.AvaliacaoDetalhe",
	service = AopService.class
)

public class AvaliacaoDetalheLocalServiceImpl
	extends AvaliacaoDetalheLocalServiceBaseImpl {


	/**
	 * Busca todos os detalhes de uma avaliação específica.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @return lista de detalhes da avaliação
	 */
	@Override
	public List<AvaliacaoDetalhe> findByAvaliacaoId(long avaliacaoId) {
		return avaliacaoDetalhePersistence.findByAvaliacaoId(avaliacaoId);
	}

	/**
	 * Busca detalhes por tipo de avaliador.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @return lista de detalhes do tipo de avaliador
	 */
	@Override
	public List<AvaliacaoDetalhe> findByTipoAvaliador(int tipoAvaliador) {
		return avaliacaoDetalhePersistence.findByTipoAvaliador(tipoAvaliador);
	}

	/**
	 * Busca detalhes por tipo de avaliador E desempenho.
	 *
	 * Usado para encontrar detalhes pendentes (desempenho = 0) de um tipo de avaliador específico.
	 *
	 * @param tipoAvaliador tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param desempenho nota de desempenho (geralmente 0 para pendentes, ou 1-5 para preenchidos)
	 * @return lista de detalhes que atendem ambos os critérios
	 */
	@Override
	public List<AvaliacaoDetalhe> findByTipoAvaliadorAndDesempenho(int tipoAvaliador, int desempenho) {
		return avaliacaoDetalhePersistence.findByTipoAvaliadorAndDesempenho(tipoAvaliador, desempenho);
	}

	/**
	 * Busca detalhes por nota de desempenho.
	 *
	 * @param desempenho nota de desempenho (1-5)
	 * @return lista de detalhes com a nota específica
	 */
	@Override
	public List<AvaliacaoDetalhe> findByDesempenho(int desempenho) {
		return avaliacaoDetalhePersistence.findByDesempenho(desempenho);
	}
	/**
	 * Adiciona um detalhe de avaliação vinculado a uma avaliação existente.
	 *
	 * @param avaliacao           Avaliação pai à qual o detalhe será vinculado
	 * @param tipoAvaliador       Tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param nomeAvaliador       Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho          Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext      Contexto de serviço com informações de auditoria
	 * @return                    O detalhe de avaliação criado
	 * @throws PortalException    se os dados fornecidos forem inválidos
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AvaliacaoDetalhe addAvaliacaoDetalhe(
			Avaliacao avaliacao,
			int tipoAvaliador,
			String nomeAvaliador,
			String observacoesAvaliador,
			int desempenho,
			ServiceContext serviceContext) throws PortalException {


		validateAvaliacaoDetalheFields(avaliacao,tipoAvaliador,desempenho);

		// Gera um ID Único
		long avaliacaoDetalheId = counterLocalService.increment(AvaliacaoDetalhe.class.getName());
		// Cria a entidade utilizando esse ID
		AvaliacaoDetalhe avaliacaoDetalhe = avaliacaoDetalhePersistence.create(avaliacaoDetalheId);

		avaliacaoDetalhe.setAvaliacaoId(avaliacao.getAvaliacaoId());
		avaliacaoDetalhe.setTipoAvaliador(tipoAvaliador);
		avaliacaoDetalhe.setNomeAvaliador(nomeAvaliador);
		avaliacaoDetalhe.setObservacoesAvaliador(observacoesAvaliador);
		avaliacaoDetalhe.setDesempenho(desempenho);

		avaliacaoDetalhe.setCompanyId(serviceContext.getCompanyId());
		avaliacaoDetalhe.setGroupId(serviceContext.getScopeGroupId());
		avaliacaoDetalhe.setUserId(serviceContext.getUserId());
		avaliacaoDetalhe.setCreateDate(new Date());
		avaliacaoDetalhe.setModifiedDate(new Date());

		AvaliacaoDetalhe detalheSalvo = super.addAvaliacaoDetalhe(avaliacaoDetalhe);

		if (isDetalhePreenchido(detalheSalvo)) {
			try {
				List<User> usuariosRH = _permissionChecker.getUsersComRole(
						"Avaliador_RH",
						serviceContext.getCompanyId()
				);

				if (!usuariosRH.isEmpty()) {
					EmailNotificationUtil.enviarNotificacaoPreenchimento(
							avaliacao,
							tipoAvaliador,
							usuariosRH
					);
					_log.info("Notificação enviada com sucesso após criação de detalhe preenchido!");
				}
			} catch (Exception e) {
				_log.warn("Erro ao enviar notificação após criação", e);
			}
		}

		return detalheSalvo;
	}

	/**
	 * Atualiza um detalhe de avaliação existente.
	 * O tipo de avaliador NÃO pode ser alterado após a criação (imutável).
	 *
	 * @param avaliacaoDetalheId   ID do detalhe a ser atualizado
	 * @param tipoAvaliador        Tipo do avaliador (deve ser igual ao original, não pode mudar)
	 * @param nomeAvaliador        Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho           Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext       Contexto de serviço com informações de auditoria
	 * @return                     O detalhe de avaliação atualizado
	 * @throws PortalException     se os dados forem inválidos ou tipo de avaliador for diferente do original
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AvaliacaoDetalhe updateAvaliacaoDetalhe(
			long avaliacaoDetalheId,
			int tipoAvaliador,
			String nomeAvaliador,
			String observacoesAvaliador,
			int desempenho,
			ServiceContext serviceContext) throws PortalException {

		// 1. Busca a avaliacaoDetalhe existente
		AvaliacaoDetalhe avaliacaoDetalhe = avaliacaoDetalhePersistence.findByPrimaryKey(avaliacaoDetalheId);

		// 2. Busca a avaliação para validação
		Avaliacao avaliacao = avaliacaoPersistence.fetchByPrimaryKey(avaliacaoDetalhe.getAvaliacaoId());

		// 2.1 Valida que tipo de avaliador não pode ser alterado
		if (avaliacaoDetalhe.getTipoAvaliador() != tipoAvaliador) {
			throw new PortalException(
					"Não é permitido alterar o tipo de avaliador após criação."
			);
		}

		// 3. Valida os novos dados
		validateAvaliacaoDetalheFieldsUpdate(nomeAvaliador, observacoesAvaliador, desempenho);

		// 4. Atualiza os campos de negócio
		avaliacaoDetalhe.setNomeAvaliador(nomeAvaliador);
		avaliacaoDetalhe.setObservacoesAvaliador(observacoesAvaliador);
		avaliacaoDetalhe.setDesempenho(desempenho);

		// 5. Atualiza campos de auditoria
		avaliacaoDetalhe.setModifiedDate(new Date());
		avaliacaoDetalhe.setUserId(serviceContext.getUserId());

		// 6. Persiste as alterações e retorna
		AvaliacaoDetalhe avaliacaoDetalheAtualizado =
				super.updateAvaliacaoDetalhe(avaliacaoDetalhe);

		try {
			Avaliacao avaliacaoPai = avaliacaoPersistence.fetchByPrimaryKey(
					avaliacaoDetalhe.getAvaliacaoId()
			);

			// Verificar se encontrou
			if (avaliacaoPai == null) {
				_log.warn("Avaliação pai não encontrada. ID: " +
						avaliacaoDetalhe.getAvaliacaoId());
				return avaliacaoDetalheAtualizado;
			}

			// Buscar usuários RH
			List<User> usuariosRH = _permissionChecker.getUsersComRole(
					"Avaliador_RH",
					serviceContext.getCompanyId()
			);

			// Enviar notificação
			if (!usuariosRH.isEmpty()) {
				EmailNotificationUtil.enviarNotificacaoPreenchimento(
						avaliacaoPai,
						tipoAvaliador,
						usuariosRH
				);

				_log.info("Notificação enviada com sucesso!");
			}

		} catch (Exception e) {
			_log.warn("Erro ao enviar notificação", e);
		}


		// 8. Retornar o objeto atualizado
		return avaliacaoDetalheAtualizado;

	}

	/**
	 * Remove um detalhe de avaliação do sistema.
	 *
	 * @param avaliacaoDetalheId ID do detalhe a ser removido
	 * @return                   O detalhe de avaliação removido
	 * @throws PortalException   se o detalhe não for encontrado
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AvaliacaoDetalhe deleteAvaliacaoDetalhe(long avaliacaoDetalheId) throws PortalException {

		AvaliacaoDetalhe avaliacaoDetalhe = avaliacaoDetalhePersistence.findByPrimaryKey(avaliacaoDetalheId);

		return super.deleteAvaliacaoDetalhe(avaliacaoDetalhe);
	}

	/**
	 * Valida os campos MÍNIMOS para criação de detalhe de avaliação.
	 * PERMITE detalhes vazios (nomeAvaliador=null, observações=null, desempenho=0).
	 * Usado no método addAvaliacaoDetalhe().
	 *
	 * @param avaliacao Avaliação pai (não pode ser nula)
	 * @param tipoAvaliador Tipo do avaliador (deve ser válido no enum: 1, 2 ou 3)
	 * @param desempenho Nota de desempenho (pode ser 0 para detalhes vazios, 1-5 quando preenchido)
	 * @throws PortalException quando avaliação pai ou tipo de avaliador for inválido
	 */
	private void validateAvaliacaoDetalheFields(
			Avaliacao avaliacao,
			int tipoAvaliador,
			int desempenho) throws PortalException {

		// Valida avaliação pai (OBRIGATÓRIA)
		if (avaliacao == null || avaliacao.getAvaliacaoId() <= 0) {
			throw new PortalException("Avaliação é obrigatória.");
		}

		// Valida tipo de avaliador (OBRIGATÓRIO)
		try {
			TipoAvaliadorEnum.fromId(tipoAvaliador);
		} catch (IllegalArgumentException e) {
			throw new PortalException("Tipo de avaliador inválido: " + tipoAvaliador);
		}

		// Valida desempenho APENAS se foi preenchido (> 0)
		if (desempenho > 0) {
			try {
				DesempenhoEnum.fromId(desempenho);
			} catch (IllegalArgumentException e) {
				throw new PortalException("Valor de desempenho inválido: " + desempenho);
			}
		}
	}

	/**
	 * Validações RIGOROSAS para UPDATE (exige campos preenchidos).
	 * Usado no método updateAvaliacaoDetalhe().
	 *
	 * @param nomeAvaliador Nome do avaliador (obrigatório)
	 * @param observacoesAvaliador Observações (obrigatório)
	 * @param desempenho Desempenho (obrigatório, 1-5)
	 * @throws PortalException se algum campo estiver vazio/inválido
	 */
	private void validateAvaliacaoDetalheFieldsUpdate(
			String nomeAvaliador,
			String observacoesAvaliador,
			int desempenho) throws PortalException {

		if (Validator.isNull(nomeAvaliador)) {
			throw new PortalException("Nome do avaliador é obrigatório.");
		}

		if (Validator.isNull(observacoesAvaliador)) {
			throw new PortalException("Observações do avaliador são obrigatórias.");
		}

		if (desempenho <= 0) {
			throw new PortalException("Desempenho é obrigatório e deve ser maior que zero.");
		}

		try {
			DesempenhoEnum.fromId(desempenho);
		} catch (IllegalArgumentException e) {
			throw new PortalException("Valor de desempenho inválido: " + desempenho);
		}
	}

	/**
	 * Verifica se um detalhe de avaliação está preenchido ou vazio.
	 * Um detalhe é considerado preenchido se possui observações OU desempenho > 0.
	 *
	 * @param detalhe detalhe de avaliação a ser verificado
	 * @return true se o detalhe está preenchido, false se está vazio
	 */
	private boolean isDetalhePreenchido(AvaliacaoDetalhe detalhe) {
		return (Validator.isNotNull(detalhe.getObservacoesAvaliador()) &&
				!detalhe.getObservacoesAvaliador().trim().isEmpty()) ||
				detalhe.getDesempenho() > 0;
	}


	private static final Log _log = LogFactoryUtil.getLog(AvaliacaoDetalheLocalServiceImpl.class);

	@Reference
	private AvaliacaoPermissionChecker _permissionChecker;

	}

