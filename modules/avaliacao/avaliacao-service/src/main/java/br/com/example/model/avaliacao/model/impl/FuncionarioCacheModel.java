/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model.impl;

import br.com.example.model.avaliacao.model.Funcionario;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Funcionario in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FuncionarioCacheModel
	implements CacheModel<Funcionario>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FuncionarioCacheModel)) {
			return false;
		}

		FuncionarioCacheModel funcionarioCacheModel =
			(FuncionarioCacheModel)object;

		if (funcionarioId == funcionarioCacheModel.funcionarioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, funcionarioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", funcionarioId=");
		sb.append(funcionarioId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", areaAtuacao=");
		sb.append(areaAtuacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funcionario toEntityModel() {
		FuncionarioImpl funcionarioImpl = new FuncionarioImpl();

		funcionarioImpl.setCompanyId(companyId);
		funcionarioImpl.setGroupId(groupId);
		funcionarioImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			funcionarioImpl.setCreateDate(null);
		}
		else {
			funcionarioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			funcionarioImpl.setModifiedDate(null);
		}
		else {
			funcionarioImpl.setModifiedDate(new Date(modifiedDate));
		}

		funcionarioImpl.setFuncionarioId(funcionarioId);

		if (nome == null) {
			funcionarioImpl.setNome("");
		}
		else {
			funcionarioImpl.setNome(nome);
		}

		if (email == null) {
			funcionarioImpl.setEmail("");
		}
		else {
			funcionarioImpl.setEmail(email);
		}

		funcionarioImpl.setAreaAtuacao(areaAtuacao);

		funcionarioImpl.resetOriginalValues();

		return funcionarioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		funcionarioId = objectInput.readLong();
		nome = objectInput.readUTF();
		email = objectInput.readUTF();

		areaAtuacao = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(funcionarioId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeInt(areaAtuacao);
	}

	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long funcionarioId;
	public String nome;
	public String email;
	public int areaAtuacao;

}