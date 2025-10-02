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
 * This class is a wrapper for {@link Funcionario}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Funcionario
 * @generated
 */
public class FuncionarioWrapper
	extends BaseModelWrapper<Funcionario>
	implements Funcionario, ModelWrapper<Funcionario> {

	public FuncionarioWrapper(Funcionario funcionario) {
		super(funcionario);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("funcionarioId", getFuncionarioId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long funcionarioId = (Long)attributes.get("funcionarioId");

		if (funcionarioId != null) {
			setFuncionarioId(funcionarioId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Integer areaAtuacao = (Integer)attributes.get("areaAtuacao");

		if (areaAtuacao != null) {
			setAreaAtuacao(areaAtuacao);
		}
	}

	@Override
	public Funcionario cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area atuacao of this funcionario.
	 *
	 * @return the area atuacao of this funcionario
	 */
	@Override
	public int getAreaAtuacao() {
		return model.getAreaAtuacao();
	}

	/**
	 * Returns the company ID of this funcionario.
	 *
	 * @return the company ID of this funcionario
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this funcionario.
	 *
	 * @return the create date of this funcionario
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this funcionario.
	 *
	 * @return the email of this funcionario
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the funcionario ID of this funcionario.
	 *
	 * @return the funcionario ID of this funcionario
	 */
	@Override
	public long getFuncionarioId() {
		return model.getFuncionarioId();
	}

	/**
	 * Returns the group ID of this funcionario.
	 *
	 * @return the group ID of this funcionario
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this funcionario.
	 *
	 * @return the modified date of this funcionario
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nome of this funcionario.
	 *
	 * @return the nome of this funcionario
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this funcionario.
	 *
	 * @return the primary key of this funcionario
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this funcionario.
	 *
	 * @return the user ID of this funcionario
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this funcionario.
	 *
	 * @return the user uuid of this funcionario
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
	 * Sets the area atuacao of this funcionario.
	 *
	 * @param areaAtuacao the area atuacao of this funcionario
	 */
	@Override
	public void setAreaAtuacao(int areaAtuacao) {
		model.setAreaAtuacao(areaAtuacao);
	}

	/**
	 * Sets the company ID of this funcionario.
	 *
	 * @param companyId the company ID of this funcionario
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this funcionario.
	 *
	 * @param createDate the create date of this funcionario
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this funcionario.
	 *
	 * @param email the email of this funcionario
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the funcionario ID of this funcionario.
	 *
	 * @param funcionarioId the funcionario ID of this funcionario
	 */
	@Override
	public void setFuncionarioId(long funcionarioId) {
		model.setFuncionarioId(funcionarioId);
	}

	/**
	 * Sets the group ID of this funcionario.
	 *
	 * @param groupId the group ID of this funcionario
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this funcionario.
	 *
	 * @param modifiedDate the modified date of this funcionario
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nome of this funcionario.
	 *
	 * @param nome the nome of this funcionario
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this funcionario.
	 *
	 * @param primaryKey the primary key of this funcionario
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this funcionario.
	 *
	 * @param userId the user ID of this funcionario
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this funcionario.
	 *
	 * @param userUuid the user uuid of this funcionario
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
	protected FuncionarioWrapper wrap(Funcionario funcionario) {
		return new FuncionarioWrapper(funcionario);
	}

}