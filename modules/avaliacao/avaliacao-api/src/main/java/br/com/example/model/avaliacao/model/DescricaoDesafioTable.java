/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package br.com.example.model.avaliacao.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;FOO_DescricaoDesafio&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DescricaoDesafio
 * @generated
 */
public class DescricaoDesafioTable extends BaseTable<DescricaoDesafioTable> {

	public static final DescricaoDesafioTable INSTANCE =
		new DescricaoDesafioTable();

	public final Column<DescricaoDesafioTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Long> descricaoDesafioId =
		createColumn(
			"descricaoDesafioId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<DescricaoDesafioTable, Long> funcionarioId =
		createColumn(
			"funcionarioId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Date> dataAvaliacao =
		createColumn(
			"dataAvaliacao", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, Integer> tipoDesafio =
		createColumn(
			"tipoDesafio", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DescricaoDesafioTable, String> observacoesGerais =
		createColumn(
			"observacoesGerais", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DescricaoDesafioTable() {
		super("FOO_DescricaoDesafio", DescricaoDesafioTable::new);
	}

}