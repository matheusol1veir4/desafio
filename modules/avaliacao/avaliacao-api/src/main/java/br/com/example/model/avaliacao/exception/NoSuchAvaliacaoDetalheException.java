/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package br.com.example.model.avaliacao.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAvaliacaoDetalheException extends NoSuchModelException {

	public NoSuchAvaliacaoDetalheException() {
	}

	public NoSuchAvaliacaoDetalheException(String msg) {
		super(msg);
	}

	public NoSuchAvaliacaoDetalheException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAvaliacaoDetalheException(Throwable throwable) {
		super(throwable);
	}

}