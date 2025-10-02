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
 * The extended model interface for the Avaliacao service. Represents a row in the &quot;DESAFIO_Avaliacao&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoModel
 * @generated
 */
@ImplementationClassName(
	"br.com.example.model.avaliacao.model.impl.AvaliacaoImpl"
)
@ProviderType
public interface Avaliacao extends AvaliacaoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>br.com.example.model.avaliacao.model.impl.AvaliacaoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Avaliacao, Long> AVALIACAO_ID_ACCESSOR =
		new Accessor<Avaliacao, Long>() {

			@Override
			public Long get(Avaliacao avaliacao) {
				return avaliacao.getAvaliacaoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Avaliacao> getTypeClass() {
				return Avaliacao.class;
			}

		};

}