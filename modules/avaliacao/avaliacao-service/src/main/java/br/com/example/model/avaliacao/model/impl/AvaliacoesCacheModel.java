/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model.impl;

import br.com.example.model.avaliacao.model.Avaliacoes;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Avaliacoes in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AvaliacoesCacheModel
	implements CacheModel<Avaliacoes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AvaliacoesCacheModel)) {
			return false;
		}

		AvaliacoesCacheModel avaliacoesCacheModel =
			(AvaliacoesCacheModel)object;

		if (avaliacoesId == avaliacoesCacheModel.avaliacoesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, avaliacoesId);
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
		sb.append(", avaliacoesId=");
		sb.append(avaliacoesId);
		sb.append(", descricaoDesafioId=");
		sb.append(descricaoDesafioId);
		sb.append(", tipoAvaliador=");
		sb.append(tipoAvaliador);
		sb.append(", nomeAvaliador=");
		sb.append(nomeAvaliador);
		sb.append(", observacoesAvaliador=");
		sb.append(observacoesAvaliador);
		sb.append(", desempenho=");
		sb.append(desempenho);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Avaliacoes toEntityModel() {
		AvaliacoesImpl avaliacoesImpl = new AvaliacoesImpl();

		avaliacoesImpl.setCompanyId(companyId);
		avaliacoesImpl.setGroupId(groupId);
		avaliacoesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			avaliacoesImpl.setCreateDate(null);
		}
		else {
			avaliacoesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			avaliacoesImpl.setModifiedDate(null);
		}
		else {
			avaliacoesImpl.setModifiedDate(new Date(modifiedDate));
		}

		avaliacoesImpl.setAvaliacoesId(avaliacoesId);
		avaliacoesImpl.setDescricaoDesafioId(descricaoDesafioId);

		if (tipoAvaliador == null) {
			avaliacoesImpl.setTipoAvaliador("");
		}
		else {
			avaliacoesImpl.setTipoAvaliador(tipoAvaliador);
		}

		if (nomeAvaliador == null) {
			avaliacoesImpl.setNomeAvaliador("");
		}
		else {
			avaliacoesImpl.setNomeAvaliador(nomeAvaliador);
		}

		if (observacoesAvaliador == null) {
			avaliacoesImpl.setObservacoesAvaliador("");
		}
		else {
			avaliacoesImpl.setObservacoesAvaliador(observacoesAvaliador);
		}

		avaliacoesImpl.setDesempenho(desempenho);

		avaliacoesImpl.resetOriginalValues();

		return avaliacoesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		avaliacoesId = objectInput.readLong();

		descricaoDesafioId = objectInput.readLong();
		tipoAvaliador = objectInput.readUTF();
		nomeAvaliador = objectInput.readUTF();
		observacoesAvaliador = objectInput.readUTF();

		desempenho = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(avaliacoesId);

		objectOutput.writeLong(descricaoDesafioId);

		if (tipoAvaliador == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipoAvaliador);
		}

		if (nomeAvaliador == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeAvaliador);
		}

		if (observacoesAvaliador == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(observacoesAvaliador);
		}

		objectOutput.writeInt(desempenho);
	}

	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long avaliacoesId;
	public long descricaoDesafioId;
	public String tipoAvaliador;
	public String nomeAvaliador;
	public String observacoesAvaliador;
	public int desempenho;

}