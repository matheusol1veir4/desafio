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
 * This class is a wrapper for {@link Avaliacao}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Avaliacao
 * @generated
 */
public class AvaliacaoWrapper
	extends BaseModelWrapper<Avaliacao>
	implements Avaliacao, ModelWrapper<Avaliacao> {

	public AvaliacaoWrapper(Avaliacao avaliacao) {
		super(avaliacao);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("avaliacaoId", getAvaliacaoId());
		attributes.put("funcionarioId", getFuncionarioId());
		attributes.put("dataAvaliacao", getDataAvaliacao());
		attributes.put("periodoDesafio", getPeriodoDesafio());
		attributes.put("observacoesGerais", getObservacoesGerais());
		attributes.put("areaAtuacao", getAreaAtuacao());

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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long avaliacaoId = (Long)attributes.get("avaliacaoId");

		if (avaliacaoId != null) {
			setAvaliacaoId(avaliacaoId);
		}

		Long funcionarioId = (Long)attributes.get("funcionarioId");

		if (funcionarioId != null) {
			setFuncionarioId(funcionarioId);
		}

		Date dataAvaliacao = (Date)attributes.get("dataAvaliacao");

		if (dataAvaliacao != null) {
			setDataAvaliacao(dataAvaliacao);
		}

		Integer periodoDesafio = (Integer)attributes.get("periodoDesafio");

		if (periodoDesafio != null) {
			setPeriodoDesafio(periodoDesafio);
		}

		String observacoesGerais = (String)attributes.get("observacoesGerais");

		if (observacoesGerais != null) {
			setObservacoesGerais(observacoesGerais);
		}

		Integer areaAtuacao = (Integer)attributes.get("areaAtuacao");

		if (areaAtuacao != null) {
			setAreaAtuacao(areaAtuacao);
		}
	}

	@Override
	public Avaliacao cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area atuacao of this avaliacao.
	 *
	 * @return the area atuacao of this avaliacao
	 */
	@Override
	public int getAreaAtuacao() {
		return model.getAreaAtuacao();
	}

	/**
	 * Returns the avaliacao ID of this avaliacao.
	 *
	 * @return the avaliacao ID of this avaliacao
	 */
	@Override
	public long getAvaliacaoId() {
		return model.getAvaliacaoId();
	}

	/**
	 * Returns the company ID of this avaliacao.
	 *
	 * @return the company ID of this avaliacao
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this avaliacao.
	 *
	 * @return the create date of this avaliacao
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data avaliacao of this avaliacao.
	 *
	 * @return the data avaliacao of this avaliacao
	 */
	@Override
	public Date getDataAvaliacao() {
		return model.getDataAvaliacao();
	}

	/**
	 * Returns the funcionario ID of this avaliacao.
	 *
	 * @return the funcionario ID of this avaliacao
	 */
	@Override
	public long getFuncionarioId() {
		return model.getFuncionarioId();
	}

	/**
	 * Returns the group ID of this avaliacao.
	 *
	 * @return the group ID of this avaliacao
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this avaliacao.
	 *
	 * @return the modified date of this avaliacao
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the observacoes gerais of this avaliacao.
	 *
	 * @return the observacoes gerais of this avaliacao
	 */
	@Override
	public String getObservacoesGerais() {
		return model.getObservacoesGerais();
	}

	/**
	 * Returns the periodo desafio of this avaliacao.
	 *
	 * @return the periodo desafio of this avaliacao
	 */
	@Override
	public int getPeriodoDesafio() {
		return model.getPeriodoDesafio();
	}

	/**
	 * Returns the primary key of this avaliacao.
	 *
	 * @return the primary key of this avaliacao
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this avaliacao.
	 *
	 * @return the user ID of this avaliacao
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this avaliacao.
	 *
	 * @return the user name of this avaliacao
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this avaliacao.
	 *
	 * @return the user uuid of this avaliacao
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
	 * Sets the area atuacao of this avaliacao.
	 *
	 * @param areaAtuacao the area atuacao of this avaliacao
	 */
	@Override
	public void setAreaAtuacao(int areaAtuacao) {
		model.setAreaAtuacao(areaAtuacao);
	}

	/**
	 * Sets the avaliacao ID of this avaliacao.
	 *
	 * @param avaliacaoId the avaliacao ID of this avaliacao
	 */
	@Override
	public void setAvaliacaoId(long avaliacaoId) {
		model.setAvaliacaoId(avaliacaoId);
	}

	/**
	 * Sets the company ID of this avaliacao.
	 *
	 * @param companyId the company ID of this avaliacao
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this avaliacao.
	 *
	 * @param createDate the create date of this avaliacao
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data avaliacao of this avaliacao.
	 *
	 * @param dataAvaliacao the data avaliacao of this avaliacao
	 */
	@Override
	public void setDataAvaliacao(Date dataAvaliacao) {
		model.setDataAvaliacao(dataAvaliacao);
	}

	/**
	 * Sets the funcionario ID of this avaliacao.
	 *
	 * @param funcionarioId the funcionario ID of this avaliacao
	 */
	@Override
	public void setFuncionarioId(long funcionarioId) {
		model.setFuncionarioId(funcionarioId);
	}

	/**
	 * Sets the group ID of this avaliacao.
	 *
	 * @param groupId the group ID of this avaliacao
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this avaliacao.
	 *
	 * @param modifiedDate the modified date of this avaliacao
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the observacoes gerais of this avaliacao.
	 *
	 * @param observacoesGerais the observacoes gerais of this avaliacao
	 */
	@Override
	public void setObservacoesGerais(String observacoesGerais) {
		model.setObservacoesGerais(observacoesGerais);
	}

	/**
	 * Sets the periodo desafio of this avaliacao.
	 *
	 * @param periodoDesafio the periodo desafio of this avaliacao
	 */
	@Override
	public void setPeriodoDesafio(int periodoDesafio) {
		model.setPeriodoDesafio(periodoDesafio);
	}

	/**
	 * Sets the primary key of this avaliacao.
	 *
	 * @param primaryKey the primary key of this avaliacao
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this avaliacao.
	 *
	 * @param userId the user ID of this avaliacao
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this avaliacao.
	 *
	 * @param userName the user name of this avaliacao
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this avaliacao.
	 *
	 * @param userUuid the user uuid of this avaliacao
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
	protected AvaliacaoWrapper wrap(Avaliacao avaliacao) {
		return new AvaliacaoWrapper(avaliacao);
	}

}