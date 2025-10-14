/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.impl;

import br.com.example.model.avaliacao.enums.AreaAtuacaoEnum;
import br.com.example.model.avaliacao.enums.PeriodoDesafioEnum;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.model.AvaliacaoDetalhe;
import br.com.example.model.avaliacao.service.base.AvaliacaoLocalServiceBaseImpl;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.ws.rs.NotFoundException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=br.com.example.model.avaliacao.model.Avaliacao",
	service = AopService.class
)
public class AvaliacaoLocalServiceImpl extends AvaliacaoLocalServiceBaseImpl {

	@Override
	public List<Avaliacao> findByFuncionarioId (long funcionarioId) {;

		return avaliacaoPersistence.findByFuncionarioId(funcionarioId);
	}

	/**
	 * Busca avaliação específica de um funcionário em determinado período.
	 * Deve ser único por regra de negócio (um funcionário só pode ter uma avaliação por período).
	 *
	 * @param funcionarioId ID do funcionário
	 * @param periodoDesafio período do desafio (30, 60 ou 90 dias)
	 * @return avaliação encontrada ou null se não existir
	 */
	@Override
	public Avaliacao findByFuncionarioIdAndPeriodoDesafio(long funcionarioId, int periodoDesafio) {
		return avaliacaoPersistence.fetchByFuncionarioIdPeriodoDesafio(funcionarioId, periodoDesafio);
	}

	/**
	 * Busca todas as avaliações de um período específico.
	 *
	 * @param periodoDesafio período do desafio (1=30, 2=60, 3=90 dias)
	 * @return lista de avaliações do período
	 */
	@Override
	public List<Avaliacao> findByPeriodoDesafio(int periodoDesafio) {
		return avaliacaoPersistence.findByPeriodoDesafio(periodoDesafio);
	}

	/**
	 * Busca avaliações por área de atuação.
	 *
	 * @param areaAtuacao área de atuação (1=Analista, 2=Tester, 3=UI, etc.)
	 * @return lista de avaliações da área
	 */
	@Override
	public List<Avaliacao> findByAreaAtuacao(int areaAtuacao) {
		return avaliacaoPersistence.findByAreaAtuacao(areaAtuacao);
	}

	/**
	 * Cria uma nova avaliação de desafio para um funcionário.
	 *
	 * @param funcionarioId     ID do usuário que está sendo avaliado
	 * @param dataAvaliacao     Data em que a avaliação está sendo criada
	 * @param periodoDesafio    Período do ciclo (30, 60 ou 90 dias)
	 * @param observacoesGerais Comentários gerais sobre a avaliação
	 * @param areaAtuacao       Área de atuação do funcionário
	 * @param serviceContext    Contexto de serviço com informações de auditoria
	 * @return                  A avaliação criada
	 * @throws PortalException  se os dados fornecidos forem inválidos
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Avaliacao addAvaliacao(
			long funcionarioId,
			Date dataAvaliacao,
			int periodoDesafio,
			String observacoesGerais,
			int areaAtuacao,
			ServiceContext serviceContext) throws PortalException {

		validateFields(funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao);

		// Gera um ID Único
		long avaliacaoId = counterLocalService.increment(Avaliacao.class.getName());
		// Cria a entidade utilizando esse ID
		Avaliacao avaliacao = avaliacaoPersistence.create(avaliacaoId);

		avaliacao.setFuncionarioId(funcionarioId);
		avaliacao.setDataAvaliacao(dataAvaliacao);
		avaliacao.setPeriodoDesafio(periodoDesafio);
		avaliacao.setObservacoesGerais(observacoesGerais);
		avaliacao.setAreaAtuacao(areaAtuacao);

		avaliacao.setCompanyId(serviceContext.getCompanyId());
		avaliacao.setGroupId(serviceContext.getScopeGroupId());
		avaliacao.setUserId(serviceContext.getUserId());
		avaliacao.setCreateDate(serviceContext.getCreateDate(new Date()));
		avaliacao.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		avaliacao = super.addAvaliacao(avaliacao);

		String emailFrom = "marcdesafio@gmail.com";
		String emailTo = "matheus.oliveira@desafio.com";
		String subject = "teste";
		String emailTitle = "testando";
		String html = "anexo";
		MailMessage mailMessage = prepareMailMessage(html, emailFrom, emailTo, subject, emailTitle, null);

		MailServiceUtil.sendEmail(mailMessage);

		return avaliacao;
	}

	private MailMessage prepareMailMessage(String html, String emailFrom, String emailTo, String subject, String emailTitle, File file) {
		try {
			InternetAddress fromAddress = new InternetAddress(emailFrom, emailTitle);
			InternetAddress toAddress = new InternetAddress(emailTo);
			MailMessage mailMessage = new MailMessage();

			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(fromAddress);
			mailMessage.setTo(toAddress);
			mailMessage.setSubject(subject);
			mailMessage.setBody(html);
			setHeaderCustomized(emailFrom, mailMessage);

			if(file != null) {
				mailMessage.addFileAttachment(file);
			}

			return mailMessage;
		} catch (AddressException | UnsupportedEncodingException e) {
			_log.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	private void setHeaderCustomized(String emailDefault, MailMessage mailMessage) {
		InternetHeaders headers = new InternetHeaders();
		headers.setHeader("Message-ID", generateMessageId(emailDefault));
		headers.setHeader("Date", new Date().toString());
		headers.setHeader("X-Mailer", "Liferay 7.4 - SESC-DF Credenciamento");
		headers.setHeader("X-Priority", "1");
		headers.setHeader("Importance", "high");
		headers.setHeader("X-MSMail-Priority", "High");
		mailMessage.setInternetHeaders(headers);
	}

	private String generateMessageId(String fromAddress) {
		try {
			long now = Instant.now().getEpochSecond();
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(Long.toString(now).getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(String.format("%02x", b));
			}
			String[] domain = fromAddress.split("@");
			return "<" + hexString.toString() + "@" + domain[1] + ">";
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error generating Message-ID", e);
		}
	}

	/**
	 * Atualiza uma avaliação existente.
	 * Não permite alterar o funcionário após criação.
	 *
	 * @param avaliacaoId       ID da avaliação a ser atualizada
	 * @param dataAvaliacao     Nova data da avaliação
	 * @param periodoDesafio    Novo período do desafio
	 * @param observacoesGerais Novas observações gerais
	 * @param areaAtuacao       Nova área de atuação
	 * @param serviceContext    Contexto de serviço
	 * @return                  A avaliação atualizada
	 * @throws PortalException  se os dados forem inválidos ou funcionário for alterado
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Avaliacao updateAvaliacao(
			long avaliacaoId,
			Date dataAvaliacao,
			int periodoDesafio,
			String observacoesGerais,
			int areaAtuacao,
			ServiceContext serviceContext) throws PortalException {

		Avaliacao avaliacao = avaliacaoPersistence.findByPrimaryKey(avaliacaoId);

		validateFields(avaliacao.getFuncionarioId(), dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao);

		avaliacao.setDataAvaliacao(dataAvaliacao);
		avaliacao.setPeriodoDesafio(periodoDesafio);
		avaliacao.setObservacoesGerais(observacoesGerais);
		avaliacao.setAreaAtuacao(areaAtuacao);

		avaliacao.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		avaliacao.setUserId(serviceContext.getUserId());


		avaliacao = super.updateAvaliacao(avaliacao);

		return avaliacao;
	}

	//TO DO: depois que implementar a AvaliacaoDetalhe precisamos implementar a deleção em cascata!!!
	/**
	 * Remove uma avaliação e todos os seus detalhes relacionados (cascade delete).
	 *
	 * @param avaliacaoId      ID da avaliação a ser removida
	 * @return                 A avaliação removida
	 * @throws PortalException se a avaliação não for encontrada ou houver erro ao deletar
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Avaliacao deleteAvaliacao(long avaliacaoId) throws PortalException {

		// 1. Busca a avaliação existente
		Avaliacao avaliacao = avaliacaoPersistence.findByPrimaryKey(avaliacaoId);

		// 2. Deleta TODOS os AvaliacaoDetalhe relacionados ANTES (CASCADE)
		deleteRelatedAvaliacaoDetalhes(avaliacaoId);

		// 3. Agora deleta a avaliação principal
		return super.deleteAvaliacao(avaliacao);
	}

	/**
	 * Remove todos os AvaliacaoDetalhe relacionados à avaliação.
	 * Este método é chamado ANTES de deletar a Avaliacao principal.
	 *
	 * @param avaliacaoId ID da avaliação pai
	 * @throws PortalException se houver erro ao deletar os detalhes
	 */
	private void deleteRelatedAvaliacaoDetalhes(long avaliacaoId) throws PortalException {

		// Busca todos os detalhes vinculados a esta avaliação usando a persistence
		List<AvaliacaoDetalhe> detalhes = avaliacaoDetalhePersistence.findByAvaliacaoId(avaliacaoId);

		// Deleta cada detalhe individualmente
		for (AvaliacaoDetalhe detalhe : detalhes) {
			avaliacaoDetalhePersistence.remove(detalhe.getAvaliacaoDetalheId());
		}
	}


	/**
	 * validateFields -> Valida os campos obrigatórios para criação/atualização de avaliação.
	 *
	 * @param funcionarioId     Valida se o usuário existe no sistema
	 * @param dataAvaliacao     Valida se a data não é nula
	 * @param periodoDesafio    Valida se o período é 30, 60 ou 90 dias
	 * @param observacoesGerais Valida se o campo não está vazio
	 * @param areaAtuacao       Valida se corresponde a uma área válida do enum
	 *
	 * @throws NotFoundException quando o funcionário não é encontrado
	 * @throws PortalException   quando outros campos são inválidos
	 */

	private void validateFields(long funcionarioId, Date dataAvaliacao, int periodoDesafio, String observacoesGerais, int areaAtuacao) throws PortalException {

		Optional
				.ofNullable(userLocalService.fetchUser(funcionarioId))
				.orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o usuario."));

		if (dataAvaliacao == null) {
			throw new PortalException("A data da avaliação é obrigatória.");
		}
		try {
			PeriodoDesafioEnum.fromId(periodoDesafio);
		} catch (IllegalArgumentException e) {
			throw new PortalException("O período do desafio é inválido.");
		}
		try {
			AreaAtuacaoEnum.fromId(areaAtuacao);
		} catch (IllegalArgumentException e) {
			throw new PortalException("A área de atuação é inválida.");
		}
		if (Validator.isNull(observacoesGerais)) {
			throw new PortalException("As observações gerais são obrigatórias.");
		}

	}

	private final Log _log = LogFactoryUtil.getLog(AvaliacaoLocalServiceImpl.class);

}