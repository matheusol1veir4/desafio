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
 * This class is a wrapper for {@link AvaliacaoDetalhe}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalhe
 * @generated
 */
public class AvaliacaoDetalheWrapper
	extends BaseModelWrapper<AvaliacaoDetalhe>
	implements AvaliacaoDetalhe, ModelWrapper<AvaliacaoDetalhe> {

	public AvaliacaoDetalheWrapper(AvaliacaoDetalhe avaliacaoDetalhe) {
		super(avaliacaoDetalhe);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("avaliacaoDetalheId", getAvaliacaoDetalheId());
		attributes.put("avaliacaoId", getAvaliacaoId());
		attributes.put("tipoAvaliador", getTipoAvaliador());
		attributes.put("nomeAvaliador", getNomeAvaliador());
		attributes.put("observacoesAvaliador", getObservacoesAvaliador());
		attributes.put("desempenho", getDesempenho());

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

		Long avaliacaoDetalheId = (Long)attributes.get("avaliacaoDetalheId");

		if (avaliacaoDetalheId != null) {
			setAvaliacaoDetalheId(avaliacaoDetalheId);
		}

		Long avaliacaoId = (Long)attributes.get("avaliacaoId");

		if (avaliacaoId != null) {
			setAvaliacaoId(avaliacaoId);
		}

		Integer tipoAvaliador = (Integer)attributes.get("tipoAvaliador");

		if (tipoAvaliador != null) {
			setTipoAvaliador(tipoAvaliador);
		}

		String nomeAvaliador = (String)attributes.get("nomeAvaliador");

		if (nomeAvaliador != null) {
			setNomeAvaliador(nomeAvaliador);
		}

		String observacoesAvaliador = (String)attributes.get(
			"observacoesAvaliador");

		if (observacoesAvaliador != null) {
			setObservacoesAvaliador(observacoesAvaliador);
		}

		Integer desempenho = (Integer)attributes.get("desempenho");

		if (desempenho != null) {
			setDesempenho(desempenho);
		}
	}

	@Override
	public AvaliacaoDetalhe cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the avaliacao detalhe ID of this avaliacao detalhe.
	 *
	 * @return the avaliacao detalhe ID of this avaliacao detalhe
	 */
	@Override
	public long getAvaliacaoDetalheId() {
		return model.getAvaliacaoDetalheId();
	}

	/**
	 * Returns the avaliacao ID of this avaliacao detalhe.
	 *
	 * @return the avaliacao ID of this avaliacao detalhe
	 */
	@Override
	public long getAvaliacaoId() {
		return model.getAvaliacaoId();
	}

	/**
	 * Returns the company ID of this avaliacao detalhe.
	 *
	 * @return the company ID of this avaliacao detalhe
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this avaliacao detalhe.
	 *
	 * @return the create date of this avaliacao detalhe
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the desempenho of this avaliacao detalhe.
	 *
	 * @return the desempenho of this avaliacao detalhe
	 */
	@Override
	public int getDesempenho() {
		return model.getDesempenho();
	}

	/**
	 * Returns the group ID of this avaliacao detalhe.
	 *
	 * @return the group ID of this avaliacao detalhe
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this avaliacao detalhe.
	 *
	 * @return the modified date of this avaliacao detalhe
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome avaliador of this avaliacao detalhe.
	 *
	 * @return the nome avaliador of this avaliacao detalhe
	 */
	@Override
	public String getNomeAvaliador() {
		return model.getNomeAvaliador();
	}

	/**
	 * Returns the observacoes avaliador of this avaliacao detalhe.
	 *
	 * @return the observacoes avaliador of this avaliacao detalhe
	 */
	@Override
	public String getObservacoesAvaliador() {
		return model.getObservacoesAvaliador();
	}

	/**
	 * Returns the primary key of this avaliacao detalhe.
	 *
	 * @return the primary key of this avaliacao detalhe
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo avaliador of this avaliacao detalhe.
	 *
	 * @return the tipo avaliador of this avaliacao detalhe
	 */
	@Override
	public int getTipoAvaliador() {
		return model.getTipoAvaliador();
	}

	/**
	 * Returns the user ID of this avaliacao detalhe.
	 *
	 * @return the user ID of this avaliacao detalhe
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this avaliacao detalhe.
	 *
	 * @return the user uuid of this avaliacao detalhe
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
	 * Sets the avaliacao detalhe ID of this avaliacao detalhe.
	 *
	 * @param avaliacaoDetalheId the avaliacao detalhe ID of this avaliacao detalhe
	 */
	@Override
	public void setAvaliacaoDetalheId(long avaliacaoDetalheId) {
		model.setAvaliacaoDetalheId(avaliacaoDetalheId);
	}

	/**
	 * Sets the avaliacao ID of this avaliacao detalhe.
	 *
	 * @param avaliacaoId the avaliacao ID of this avaliacao detalhe
	 */
	@Override
	public void setAvaliacaoId(long avaliacaoId) {
		model.setAvaliacaoId(avaliacaoId);
	}

	/**
	 * Sets the company ID of this avaliacao detalhe.
	 *
	 * @param companyId the company ID of this avaliacao detalhe
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this avaliacao detalhe.
	 *
	 * @param createDate the create date of this avaliacao detalhe
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the desempenho of this avaliacao detalhe.
	 *
	 * @param desempenho the desempenho of this avaliacao detalhe
	 */
	@Override
	public void setDesempenho(int desempenho) {
		model.setDesempenho(desempenho);
	}

	/**
	 * Sets the group ID of this avaliacao detalhe.
	 *
	 * @param groupId the group ID of this avaliacao detalhe
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this avaliacao detalhe.
	 *
	 * @param modifiedDate the modified date of this avaliacao detalhe
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome avaliador of this avaliacao detalhe.
	 *
	 * @param nomeAvaliador the nome avaliador of this avaliacao detalhe
	 */
	@Override
	public void setNomeAvaliador(String nomeAvaliador) {
		model.setNomeAvaliador(nomeAvaliador);
	}

	/**
	 * Sets the observacoes avaliador of this avaliacao detalhe.
	 *
	 * @param observacoesAvaliador the observacoes avaliador of this avaliacao detalhe
	 */
	@Override
	public void setObservacoesAvaliador(String observacoesAvaliador) {
		model.setObservacoesAvaliador(observacoesAvaliador);
	}

	/**
	 * Sets the primary key of this avaliacao detalhe.
	 *
	 * @param primaryKey the primary key of this avaliacao detalhe
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo avaliador of this avaliacao detalhe.
	 *
	 * @param tipoAvaliador the tipo avaliador of this avaliacao detalhe
	 */
	@Override
	public void setTipoAvaliador(int tipoAvaliador) {
		model.setTipoAvaliador(tipoAvaliador);
	}

	/**
	 * Sets the user ID of this avaliacao detalhe.
	 *
	 * @param userId the user ID of this avaliacao detalhe
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this avaliacao detalhe.
	 *
	 * @param userUuid the user uuid of this avaliacao detalhe
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
	protected AvaliacaoDetalheWrapper wrap(AvaliacaoDetalhe avaliacaoDetalhe) {
		return new AvaliacaoDetalheWrapper(avaliacaoDetalhe);
	}

}