/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model.impl;

import br.com.example.model.avaliacao.model.DescricaoDesafio;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DescricaoDesafio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DescricaoDesafioCacheModel
	implements CacheModel<DescricaoDesafio>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DescricaoDesafioCacheModel)) {
			return false;
		}

		DescricaoDesafioCacheModel descricaoDesafioCacheModel =
			(DescricaoDesafioCacheModel)object;

		if (descricaoDesafioId ==
				descricaoDesafioCacheModel.descricaoDesafioId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, descricaoDesafioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", descricaoDesafioId=");
		sb.append(descricaoDesafioId);
		sb.append(", funcionarioId=");
		sb.append(funcionarioId);
		sb.append(", dataAvaliacao=");
		sb.append(dataAvaliacao);
		sb.append(", tipoDesafio=");
		sb.append(tipoDesafio);
		sb.append(", observacoesGerais=");
		sb.append(observacoesGerais);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DescricaoDesafio toEntityModel() {
		DescricaoDesafioImpl descricaoDesafioImpl = new DescricaoDesafioImpl();

		descricaoDesafioImpl.setCompanyId(companyId);
		descricaoDesafioImpl.setGroupId(groupId);
		descricaoDesafioImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			descricaoDesafioImpl.setCreateDate(null);
		}
		else {
			descricaoDesafioImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			descricaoDesafioImpl.setModifiedDate(null);
		}
		else {
			descricaoDesafioImpl.setModifiedDate(new Date(modifiedDate));
		}

		descricaoDesafioImpl.setDescricaoDesafioId(descricaoDesafioId);
		descricaoDesafioImpl.setFuncionarioId(funcionarioId);

		if (dataAvaliacao == Long.MIN_VALUE) {
			descricaoDesafioImpl.setDataAvaliacao(null);
		}
		else {
			descricaoDesafioImpl.setDataAvaliacao(new Date(dataAvaliacao));
		}

		descricaoDesafioImpl.setTipoDesafio(tipoDesafio);

		if (observacoesGerais == null) {
			descricaoDesafioImpl.setObservacoesGerais("");
		}
		else {
			descricaoDesafioImpl.setObservacoesGerais(observacoesGerais);
		}

		descricaoDesafioImpl.resetOriginalValues();

		return descricaoDesafioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		descricaoDesafioId = objectInput.readLong();

		funcionarioId = objectInput.readLong();
		dataAvaliacao = objectInput.readLong();

		tipoDesafio = objectInput.readInt();
		observacoesGerais = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(descricaoDesafioId);

		objectOutput.writeLong(funcionarioId);
		objectOutput.writeLong(dataAvaliacao);

		objectOutput.writeInt(tipoDesafio);

		if (observacoesGerais == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(observacoesGerais);
		}
	}

	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long descricaoDesafioId;
	public long funcionarioId;
	public long dataAvaliacao;
	public int tipoDesafio;
	public String observacoesGerais;

}