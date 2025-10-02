/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.service.persistence.impl;

import br.com.example.model.avaliacao.model.DescricaoDesafioTable;
import br.com.example.model.avaliacao.model.impl.DescricaoDesafioImpl;
import br.com.example.model.avaliacao.model.impl.DescricaoDesafioModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from DescricaoDesafio.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=br.com.example.model.avaliacao.model.impl.DescricaoDesafioImpl",
		"table.name=FOO_DescricaoDesafio"
	},
	service = ArgumentsResolver.class
)
public class DescricaoDesafioModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		DescricaoDesafioModelImpl descricaoDesafioModelImpl =
			(DescricaoDesafioModelImpl)baseModel;

		long columnBitmask = descricaoDesafioModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(descricaoDesafioModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					descricaoDesafioModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(descricaoDesafioModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return DescricaoDesafioImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return DescricaoDesafioTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		DescricaoDesafioModelImpl descricaoDesafioModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = descricaoDesafioModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = descricaoDesafioModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}