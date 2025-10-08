/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.impl;

import br.com.example.model.avaliacao.enums.DesempenhoEnum;
import br.com.example.model.avaliacao.enums.TipoAvaliadorEnum;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.service.AvaliacaoLocalService;
import br.com.example.model.avaliacao.service.base.AvaliacaoDetalheLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;

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

	@Override
	public AvaliacaoDetalhe addAvaliacaoDetalhe(
			Avaliacao avaliacao,
			int tipoAvaliador,
			String nomeAvaliador,
			String observacoesAvaliador,
			int desempenho,
			ServiceContext serviceContext) throws PortalException {


		validateAvaliacaoDetalheFields(avaliacao, tipoAvaliador, nomeAvaliador, observacoesAvaliador, desempenho);

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

		return super.addAvaliacaoDetalhe(avaliacaoDetalhe);
	}

	/**
	 * Atualiza um detalhe de avaliação existente.
	 *
	 * @param avaliacaoDetalheId   ID do detalhe a ser atualizado
	 * @param tipoAvaliador        Tipo do avaliador (1=TechLead, 2=Gerente, 3=RH)
	 * @param nomeAvaliador        Nome completo do avaliador
	 * @param observacoesAvaliador Comentários específicos do avaliador
	 * @param desempenho           Nota de desempenho (1-5 conforme DesempenhoEnum)
	 * @param serviceContext       Contexto de serviço com informações de auditoria
	 * @return                     O detalhe de avaliação atualizado
	 * @throws PortalException     se os dados fornecidos forem inválidos
	 */
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
		Avaliacao avaliacao = avaliacaoLocalService.getAvaliacao(avaliacaoDetalhe.getAvaliacaoId());

		// 3. Valida os novos dados
		validateAvaliacaoDetalheFields(avaliacao, tipoAvaliador, nomeAvaliador, observacoesAvaliador, desempenho);

		// 4. Atualiza os campos de negócio
		avaliacaoDetalhe.setTipoAvaliador(tipoAvaliador);
		avaliacaoDetalhe.setNomeAvaliador(nomeAvaliador);
		avaliacaoDetalhe.setObservacoesAvaliador(observacoesAvaliador);
		avaliacaoDetalhe.setDesempenho(desempenho);

		// 5. Atualiza campos de auditoria
		avaliacaoDetalhe.setModifiedDate(new Date());
		avaliacaoDetalhe.setUserId(serviceContext.getUserId());

		// 6. Persiste as alterações
		return super.updateAvaliacaoDetalhe(avaliacaoDetalhe);
	}

	/**
	 * Remove um detalhe de avaliação do sistema.
	 *
	 * @param avaliacaoDetalheId ID do detalhe a ser removido
	 * @return                   O detalhe de avaliação removido
	 * @throws PortalException   se o detalhe não for encontrado
	 */
	@Override
	public AvaliacaoDetalhe deleteAvaliacaoDetalhe(long avaliacaoDetalheId) throws PortalException {

		AvaliacaoDetalhe avaliacaoDetalhe = avaliacaoDetalhePersistence.findByPrimaryKey(avaliacaoDetalheId);

		return super.deleteAvaliacaoDetalhe(avaliacaoDetalhe);
	}


	/**
	 * Valida os campos obrigatórios para criação de detalhe de avaliação.
	 *
	 * @param avaliacao            Avaliação pai (não pode ser nula)
	 * @param tipoAvaliador        Tipo do avaliador (deve ser válido no enum)
	 * @param nomeAvaliador        Nome do avaliador (não pode estar vazio)
	 * @param observacoesAvaliador Observações (não pode estar vazio)
	 * @param desempenho           Nota de desempenho (deve ser válida no enum)
	 * @throws PortalException     quando algum campo é inválido
	 */
	private void validateAvaliacaoDetalheFields(
			Avaliacao avaliacao,
			int tipoAvaliador,          // ← int
			String nomeAvaliador,
			String observacoesAvaliador,
			int desempenho) throws PortalException {


		if (avaliacao == null || avaliacao.getAvaliacaoId() <= 0) {
			throw new PortalException("Avaliação pai é obrigatória.");
		}


		try {
			TipoAvaliadorEnum.fromId(tipoAvaliador);  // ← Use fromId para int
		} catch (IllegalArgumentException e) {
			throw new PortalException("Tipo de avaliador inválido: " + tipoAvaliador);
		}


		if (Validator.isNull(nomeAvaliador)) {
			throw new PortalException("Nome do avaliador é obrigatório.");
		}


		if (Validator.isNull(observacoesAvaliador)) {
			throw new PortalException("Observações do avaliador são obrigatórias.");
		}


		try {
			DesempenhoEnum.fromId(desempenho);
		} catch (IllegalArgumentException e) {
			throw new PortalException("Valor de desempenho inválido: " + desempenho);
		}
	}

	@Reference
	private AvaliacaoLocalService avaliacaoLocalService;

	}

