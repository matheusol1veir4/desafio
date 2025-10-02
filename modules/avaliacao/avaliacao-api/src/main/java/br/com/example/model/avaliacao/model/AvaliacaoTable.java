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
 * The table class for the &quot;DESAFIO_Avaliacao&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Avaliacao
 * @generated
 */
public class AvaliacaoTable extends BaseTable<AvaliacaoTable> {

	public static final AvaliacaoTable INSTANCE = new AvaliacaoTable();

	public final Column<AvaliacaoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Long> avaliacaoId = createColumn(
		"avaliacaoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AvaliacaoTable, Long> funcionarioId = createColumn(
		"funcionarioId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Date> dataAvaliacao = createColumn(
		"dataAvaliacao", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Integer> periodoDesafio = createColumn(
		"periodoDesafio", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, String> observacoesGerais =
		createColumn(
			"observacoesGerais", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AvaliacaoTable, Integer> areaAtuacao = createColumn(
		"areaAtuacao", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private AvaliacaoTable() {
		super("DESAFIO_Avaliacao", AvaliacaoTable::new);
	}

}