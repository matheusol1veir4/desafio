/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DescricaoDesafio service. Represents a row in the &quot;FOO_DescricaoDesafio&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafioModel
 * @generated
 */
@ImplementationClassName(
	"br.com.example.model.avaliacao.model.impl.DescricaoDesafioImpl"
)
@ProviderType
public interface DescricaoDesafio
	extends DescricaoDesafioModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>br.com.example.model.avaliacao.model.impl.DescricaoDesafioImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DescricaoDesafio, Long>
		DESCRICAO_DESAFIO_ID_ACCESSOR = new Accessor<DescricaoDesafio, Long>() {

			@Override
			public Long get(DescricaoDesafio descricaoDesafio) {
				return descricaoDesafio.getDescricaoDesafioId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DescricaoDesafio> getTypeClass() {
				return DescricaoDesafio.class;
			}

		};

}