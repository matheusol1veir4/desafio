/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DescricaoDesafio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafio
 * @generated
 */
public class DescricaoDesafioWrapper
	extends BaseModelWrapper<DescricaoDesafio>
	implements DescricaoDesafio, ModelWrapper<DescricaoDesafio> {

	public DescricaoDesafioWrapper(DescricaoDesafio descricaoDesafio) {
		super(descricaoDesafio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("descricaoDesafioId", getDescricaoDesafioId());
		attributes.put("funcionarioId", getFuncionarioId());
		attributes.put("dataAvaliacao", getDataAvaliacao());
		attributes.put("tipoDesafio", getTipoDesafio());
		attributes.put("observacoesGerais", getObservacoesGerais());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long descricaoDesafioId = (Long)attributes.get("descricaoDesafioId");

		if (descricaoDesafioId != null) {
			setDescricaoDesafioId(descricaoDesafioId);
		}

		Long funcionarioId = (Long)attributes.get("funcionarioId");

		if (funcionarioId != null) {
			setFuncionarioId(funcionarioId);
		}

		Date dataAvaliacao = (Date)attributes.get("dataAvaliacao");

		if (dataAvaliacao != null) {
			setDataAvaliacao(dataAvaliacao);
		}

		Integer tipoDesafio = (Integer)attributes.get("tipoDesafio");

		if (tipoDesafio != null) {
			setTipoDesafio(tipoDesafio);
		}

		String observacoesGerais = (String)attributes.get("observacoesGerais");

		if (observacoesGerais != null) {
			setObservacoesGerais(observacoesGerais);
		}
	}

	@Override
	public DescricaoDesafio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this descricao desafio.
	 *
	 * @return the company ID of this descricao desafio
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this descricao desafio.
	 *
	 * @return the create date of this descricao desafio
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data avaliacao of this descricao desafio.
	 *
	 * @return the data avaliacao of this descricao desafio
	 */
	@Override
	public Date getDataAvaliacao() {
		return model.getDataAvaliacao();
	}

	/**
	 * Returns the descricao desafio ID of this descricao desafio.
	 *
	 * @return the descricao desafio ID of this descricao desafio
	 */
	@Override
	public long getDescricaoDesafioId() {
		return model.getDescricaoDesafioId();
	}

	/**
	 * Returns the funcionario ID of this descricao desafio.
	 *
	 * @return the funcionario ID of this descricao desafio
	 */
	@Override
	public long getFuncionarioId() {
		return model.getFuncionarioId();
	}

	/**
	 * Returns the group ID of this descricao desafio.
	 *
	 * @return the group ID of this descricao desafio
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this descricao desafio.
	 *
	 * @return the modified date of this descricao desafio
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the observacoes gerais of this descricao desafio.
	 *
	 * @return the observacoes gerais of this descricao desafio
	 */
	@Override
	public String getObservacoesGerais() {
		return model.getObservacoesGerais();
	}

	/**
	 * Returns the primary key of this descricao desafio.
	 *
	 * @return the primary key of this descricao desafio
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo desafio of this descricao desafio.
	 *
	 * @return the tipo desafio of this descricao desafio
	 */
	@Override
	public int getTipoDesafio() {
		return model.getTipoDesafio();
	}

	/**
	 * Returns the user ID of this descricao desafio.
	 *
	 * @return the user ID of this descricao desafio
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this descricao desafio.
	 *
	 * @return the user uuid of this descricao desafio
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this descricao desafio.
	 *
	 * @param companyId the company ID of this descricao desafio
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this descricao desafio.
	 *
	 * @param createDate the create date of this descricao desafio
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data avaliacao of this descricao desafio.
	 *
	 * @param dataAvaliacao the data avaliacao of this descricao desafio
	 */
	@Override
	public void setDataAvaliacao(Date dataAvaliacao) {
		model.setDataAvaliacao(dataAvaliacao);
	}

	/**
	 * Sets the descricao desafio ID of this descricao desafio.
	 *
	 * @param descricaoDesafioId the descricao desafio ID of this descricao desafio
	 */
	@Override
	public void setDescricaoDesafioId(long descricaoDesafioId) {
		model.setDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Sets the funcionario ID of this descricao desafio.
	 *
	 * @param funcionarioId the funcionario ID of this descricao desafio
	 */
	@Override
	public void setFuncionarioId(long funcionarioId) {
		model.setFuncionarioId(funcionarioId);
	}

	/**
	 * Sets the group ID of this descricao desafio.
	 *
	 * @param groupId the group ID of this descricao desafio
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this descricao desafio.
	 *
	 * @param modifiedDate the modified date of this descricao desafio
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the observacoes gerais of this descricao desafio.
	 *
	 * @param observacoesGerais the observacoes gerais of this descricao desafio
	 */
	@Override
	public void setObservacoesGerais(String observacoesGerais) {
		model.setObservacoesGerais(observacoesGerais);
	}

	/**
	 * Sets the primary key of this descricao desafio.
	 *
	 * @param primaryKey the primary key of this descricao desafio
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo desafio of this descricao desafio.
	 *
	 * @param tipoDesafio the tipo desafio of this descricao desafio
	 */
	@Override
	public void setTipoDesafio(int tipoDesafio) {
		model.setTipoDesafio(tipoDesafio);
	}

	/**
	 * Sets the user ID of this descricao desafio.
	 *
	 * @param userId the user ID of this descricao desafio
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this descricao desafio.
	 *
	 * @param userUuid the user uuid of this descricao desafio
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DescricaoDesafioWrapper wrap(DescricaoDesafio descricaoDesafio) {
		return new DescricaoDesafioWrapper(descricaoDesafio);
	}

}