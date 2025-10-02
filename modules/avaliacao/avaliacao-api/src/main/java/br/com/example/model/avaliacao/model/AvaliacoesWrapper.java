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
 * This class is a wrapper for {@link Avaliacoes}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Avaliacoes
 * @generated
 */
public class AvaliacoesWrapper
	extends BaseModelWrapper<Avaliacoes>
	implements Avaliacoes, ModelWrapper<Avaliacoes> {

	public AvaliacoesWrapper(Avaliacoes avaliacoes) {
		super(avaliacoes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("avaliacoesId", getAvaliacoesId());
		attributes.put("descricaoDesafioId", getDescricaoDesafioId());
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

		Long avaliacoesId = (Long)attributes.get("avaliacoesId");

		if (avaliacoesId != null) {
			setAvaliacoesId(avaliacoesId);
		}

		Long descricaoDesafioId = (Long)attributes.get("descricaoDesafioId");

		if (descricaoDesafioId != null) {
			setDescricaoDesafioId(descricaoDesafioId);
		}

		String tipoAvaliador = (String)attributes.get("tipoAvaliador");

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
	public Avaliacoes cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the avaliacoes ID of this avaliacoes.
	 *
	 * @return the avaliacoes ID of this avaliacoes
	 */
	@Override
	public long getAvaliacoesId() {
		return model.getAvaliacoesId();
	}

	/**
	 * Returns the company ID of this avaliacoes.
	 *
	 * @return the company ID of this avaliacoes
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this avaliacoes.
	 *
	 * @return the create date of this avaliacoes
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the descricao desafio ID of this avaliacoes.
	 *
	 * @return the descricao desafio ID of this avaliacoes
	 */
	@Override
	public long getDescricaoDesafioId() {
		return model.getDescricaoDesafioId();
	}

	/**
	 * Returns the desempenho of this avaliacoes.
	 *
	 * @return the desempenho of this avaliacoes
	 */
	@Override
	public int getDesempenho() {
		return model.getDesempenho();
	}

	/**
	 * Returns the group ID of this avaliacoes.
	 *
	 * @return the group ID of this avaliacoes
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this avaliacoes.
	 *
	 * @return the modified date of this avaliacoes
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome avaliador of this avaliacoes.
	 *
	 * @return the nome avaliador of this avaliacoes
	 */
	@Override
	public String getNomeAvaliador() {
		return model.getNomeAvaliador();
	}

	/**
	 * Returns the observacoes avaliador of this avaliacoes.
	 *
	 * @return the observacoes avaliador of this avaliacoes
	 */
	@Override
	public String getObservacoesAvaliador() {
		return model.getObservacoesAvaliador();
	}

	/**
	 * Returns the primary key of this avaliacoes.
	 *
	 * @return the primary key of this avaliacoes
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo avaliador of this avaliacoes.
	 *
	 * @return the tipo avaliador of this avaliacoes
	 */
	@Override
	public String getTipoAvaliador() {
		return model.getTipoAvaliador();
	}

	/**
	 * Returns the user ID of this avaliacoes.
	 *
	 * @return the user ID of this avaliacoes
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this avaliacoes.
	 *
	 * @return the user uuid of this avaliacoes
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
	 * Sets the avaliacoes ID of this avaliacoes.
	 *
	 * @param avaliacoesId the avaliacoes ID of this avaliacoes
	 */
	@Override
	public void setAvaliacoesId(long avaliacoesId) {
		model.setAvaliacoesId(avaliacoesId);
	}

	/**
	 * Sets the company ID of this avaliacoes.
	 *
	 * @param companyId the company ID of this avaliacoes
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this avaliacoes.
	 *
	 * @param createDate the create date of this avaliacoes
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the descricao desafio ID of this avaliacoes.
	 *
	 * @param descricaoDesafioId the descricao desafio ID of this avaliacoes
	 */
	@Override
	public void setDescricaoDesafioId(long descricaoDesafioId) {
		model.setDescricaoDesafioId(descricaoDesafioId);
	}

	/**
	 * Sets the desempenho of this avaliacoes.
	 *
	 * @param desempenho the desempenho of this avaliacoes
	 */
	@Override
	public void setDesempenho(int desempenho) {
		model.setDesempenho(desempenho);
	}

	/**
	 * Sets the group ID of this avaliacoes.
	 *
	 * @param groupId the group ID of this avaliacoes
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this avaliacoes.
	 *
	 * @param modifiedDate the modified date of this avaliacoes
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome avaliador of this avaliacoes.
	 *
	 * @param nomeAvaliador the nome avaliador of this avaliacoes
	 */
	@Override
	public void setNomeAvaliador(String nomeAvaliador) {
		model.setNomeAvaliador(nomeAvaliador);
	}

	/**
	 * Sets the observacoes avaliador of this avaliacoes.
	 *
	 * @param observacoesAvaliador the observacoes avaliador of this avaliacoes
	 */
	@Override
	public void setObservacoesAvaliador(String observacoesAvaliador) {
		model.setObservacoesAvaliador(observacoesAvaliador);
	}

	/**
	 * Sets the primary key of this avaliacoes.
	 *
	 * @param primaryKey the primary key of this avaliacoes
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo avaliador of this avaliacoes.
	 *
	 * @param tipoAvaliador the tipo avaliador of this avaliacoes
	 */
	@Override
	public void setTipoAvaliador(String tipoAvaliador) {
		model.setTipoAvaliador(tipoAvaliador);
	}

	/**
	 * Sets the user ID of this avaliacoes.
	 *
	 * @param userId the user ID of this avaliacoes
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this avaliacoes.
	 *
	 * @param userUuid the user uuid of this avaliacoes
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
	protected AvaliacoesWrapper wrap(Avaliacoes avaliacoes) {
		return new AvaliacoesWrapper(avaliacoes);
	}

}