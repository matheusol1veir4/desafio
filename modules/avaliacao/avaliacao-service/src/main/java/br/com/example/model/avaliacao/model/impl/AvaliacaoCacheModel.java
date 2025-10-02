/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model.impl;

import br.com.example.model.avaliacao.model.Avaliacao;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Avaliacao in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AvaliacaoCacheModel
	implements CacheModel<Avaliacao>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AvaliacaoCacheModel)) {
			return false;
		}

		AvaliacaoCacheModel avaliacaoCacheModel = (AvaliacaoCacheModel)object;

		if (avaliacaoId == avaliacaoCacheModel.avaliacaoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, avaliacaoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", avaliacaoId=");
		sb.append(avaliacaoId);
		sb.append(", funcionarioId=");
		sb.append(funcionarioId);
		sb.append(", dataAvaliacao=");
		sb.append(dataAvaliacao);
		sb.append(", periodoDesafio=");
		sb.append(periodoDesafio);
		sb.append(", observacoesGerais=");
		sb.append(observacoesGerais);
		sb.append(", areaAtuacao=");
		sb.append(areaAtuacao);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Avaliacao toEntityModel() {
		AvaliacaoImpl avaliacaoImpl = new AvaliacaoImpl();

		avaliacaoImpl.setCompanyId(companyId);
		avaliacaoImpl.setGroupId(groupId);
		avaliacaoImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			avaliacaoImpl.setCreateDate(null);
		}
		else {
			avaliacaoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			avaliacaoImpl.setModifiedDate(null);
		}
		else {
			avaliacaoImpl.setModifiedDate(new Date(modifiedDate));
		}

		avaliacaoImpl.setAvaliacaoId(avaliacaoId);
		avaliacaoImpl.setFuncionarioId(funcionarioId);

		if (dataAvaliacao == Long.MIN_VALUE) {
			avaliacaoImpl.setDataAvaliacao(null);
		}
		else {
			avaliacaoImpl.setDataAvaliacao(new Date(dataAvaliacao));
		}

		avaliacaoImpl.setPeriodoDesafio(periodoDesafio);

		if (observacoesGerais == null) {
			avaliacaoImpl.setObservacoesGerais("");
		}
		else {
			avaliacaoImpl.setObservacoesGerais(observacoesGerais);
		}

		avaliacaoImpl.setAreaAtuacao(areaAtuacao);

		avaliacaoImpl.resetOriginalValues();

		return avaliacaoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		avaliacaoId = objectInput.readLong();

		funcionarioId = objectInput.readLong();
		dataAvaliacao = objectInput.readLong();

		periodoDesafio = objectInput.readInt();
		observacoesGerais = objectInput.readUTF();

		areaAtuacao = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(avaliacaoId);

		objectOutput.writeLong(funcionarioId);
		objectOutput.writeLong(dataAvaliacao);

		objectOutput.writeInt(periodoDesafio);

		if (observacoesGerais == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(observacoesGerais);
		}

		objectOutput.writeInt(areaAtuacao);
	}

	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long avaliacaoId;
	public long funcionarioId;
	public long dataAvaliacao;
	public int periodoDesafio;
	public String observacoesGerais;
	public int areaAtuacao;

}