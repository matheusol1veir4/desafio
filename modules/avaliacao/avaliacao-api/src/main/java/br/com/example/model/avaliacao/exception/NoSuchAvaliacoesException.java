/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package br.com.example.model.avaliacao.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAvaliacoesException extends NoSuchModelException {

	public NoSuchAvaliacoesException() {
	}

	public NoSuchAvaliacoesException(String msg) {
		super(msg);
	}

	public NoSuchAvaliacoesException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAvaliacoesException(Throwable throwable) {
		super(throwable);
	}

}