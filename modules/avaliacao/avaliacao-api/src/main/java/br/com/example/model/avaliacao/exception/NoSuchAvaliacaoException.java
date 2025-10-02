/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package br.com.example.model.avaliacao.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAvaliacaoException extends NoSuchModelException {

	public NoSuchAvaliacaoException() {
	}

	public NoSuchAvaliacaoException(String msg) {
		super(msg);
	}

	public NoSuchAvaliacaoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAvaliacaoException(Throwable throwable) {
		super(throwable);
	}

}