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
 * The table class for the &quot;FOO_Funcionario&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Funcionario
 * @generated
 */
public class FuncionarioTable extends BaseTable<FuncionarioTable> {

	public static final FuncionarioTable INSTANCE = new FuncionarioTable();

	public final Column<FuncionarioTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Long> funcionarioId = createColumn(
		"funcionarioId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FuncionarioTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FuncionarioTable, Integer> areaAtuacao = createColumn(
		"areaAtuacao", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private FuncionarioTable() {
		super("FOO_Funcionario", FuncionarioTable::new);
	}

}