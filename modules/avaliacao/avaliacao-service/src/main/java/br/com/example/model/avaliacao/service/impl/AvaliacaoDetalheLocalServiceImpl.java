/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.impl;

import br.com.example.model.avaliacao.service.base.AvaliacaoDetalheLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=br.com.example.model.avaliacao.model.AvaliacaoDetalhe",
	service = AopService.class
)
public class AvaliacaoDetalheLocalServiceImpl
	extends AvaliacaoDetalheLocalServiceBaseImpl {
}