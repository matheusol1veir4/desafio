/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.impl;

import br.com.example.model.avaliacao.enums.AreaAtuacaoEnum;
import br.com.example.model.avaliacao.enums.PeriodoDesafioEnum;
import br.com.example.model.avaliacao.model.Avaliacao;
import br.com.example.model.avaliacao.service.base.AvaliacaoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=br.com.example.model.avaliacao.model.Avaliacao",
	service = AopService.class
)
public class AvaliacaoLocalServiceImpl extends AvaliacaoLocalServiceBaseImpl {

	/**
	 * @param funcionarioId O ID do funcionário.
	 * @param dataAvaliacao A data da avaliação.
	 * @param periodoDesafio O tipo da avaliação.
	 * @param observacoesGerais Observações gerais da avaliação.
	 * @param areaAtuacao A área de atuação do funcionário.
	 * @throws PortalException
	 */

	@Override
	public Avaliacao addAvaliacao(
			long funcionarioId,
			Date dataAvaliacao,
			int periodoDesafio,
			String observacoesGerais,
			int areaAtuacao,
			ServiceContext serviceContext) throws PortalException {

		validateFields(funcionarioId, dataAvaliacao, periodoDesafio, observacoesGerais, areaAtuacao);

		//validar com o Marc
		long avaliacaoId = counterLocalService.increment(Avaliacao.class.getName());

		Avaliacao avaliacao = avaliacaoPersistence.create(avaliacaoId);

		avaliacao.setFuncionarioId(funcionarioId);
		avaliacao.setDataAvaliacao(dataAvaliacao); // aqui será que tem que fazer alguma conversão ?
		avaliacao.setPeriodoDesafio(periodoDesafio);
		avaliacao.setObservacoesGerais(observacoesGerais);
		avaliacao.setAreaAtuacao(areaAtuacao);

		avaliacao.setCompanyId(serviceContext.getCompanyId());
		avaliacao.setGroupId(serviceContext.getScopeGroupId());
		avaliacao.setUserId(serviceContext.getUserId());
		avaliacao.setCreateDate(serviceContext.getCreateDate(new Date()));
		avaliacao.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		avaliacao = super.addAvaliacao(avaliacao);

		return avaliacao;
	}


//	private void validateFields (long funcionarioId, Date dataAvaliacao, int periodoDesafio, String observacoesGerais, AreaAtuacaoEnum areaAtuacaoEnum) throws PortalException {
//		// tenho que por null ? ou zero ?
//		// vou validar o campo de funcionário ?
//		if (funcionarioId <= 0) {
//			throw new PortalException("Funcionário inválido.");
//		}
//		if (dataAvaliacao == null || dataAvaliacao.after(new Date())) {
//			throw new PortalException("Data da avaliação inválida.");
//		}
//		// tenho que por null ? ou zero ?
//		if (periodoDesafio <= 0) {
//			throw new PortalException("Período do desafio inválido.");
//		}
//		// tenho que por null ? ou zero ?
//		if (areaAtuacaoEnum == null || areaAtuacaoEnum.getId() <= 0){
//			throw new PortalException("Área de atuação inválida.");
//		}
//		if (observacoesGerais == null || observacoesGerais.trim().isEmpty()) {
//			throw new PortalException("Observações gerais inválidas.");
//		}

	private void validateFields(long funcionarioId, Date dataAvaliacao, int periodoDesafio, String observacoesGerais, int areaAtuacao) throws PortalException {

		// Valida o funcionário que está sendo avaliado
		if (funcionarioId <= 0) {
			throw new PortalException("O funcionário a ser avaliado é obrigatório.");
		}

		// Valida a data da avaliação
		if (dataAvaliacao == null) {
			throw new PortalException("A data da avaliação é obrigatória.");
		}

		// Valida o período do desafio (30, 60, 90)
		// Usando o enum para validação
		try {
			PeriodoDesafioEnum.fromId(periodoDesafio);
		} catch (IllegalArgumentException e) {
			throw new PortalException("O período do desafio é inválido.");
		}

		// Valida a área de atuação usando o enum
		try {
			AreaAtuacaoEnum.fromId(areaAtuacao);
		} catch (IllegalArgumentException e) {
			throw new PortalException("A área de atuação é inválida.");
		}

		// Valida as observações
		if (Validator.isNull(observacoesGerais)) {
			throw new PortalException("As observações gerais são obrigatórias.");
		}

	}


}