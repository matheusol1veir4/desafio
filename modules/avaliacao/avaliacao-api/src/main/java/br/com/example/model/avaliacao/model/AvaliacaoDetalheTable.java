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
 * The table class for the &quot;DESAFIO_AvaliacaoDetalhe&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AvaliacaoDetalhe
 * @generated
 */
public class AvaliacaoDetalheTable extends BaseTable<AvaliacaoDetalheTable> {

	public static final AvaliacaoDetalheTable INSTANCE =
		new AvaliacaoDetalheTable();

	public final Column<AvaliacaoDetalheTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Long> avaliacaoDetalheId =
		createColumn(
			"avaliacaoDetalheId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AvaliacaoDetalheTable, Long> avaliacaoId = createColumn(
		"avaliacaoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, String> tipoAvaliador =
		createColumn(
			"tipoAvaliador", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, String> nomeAvaliador =
		createColumn(
			"nomeAvaliador", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, String> observacoesAvaliador =
		createColumn(
			"observacoesAvaliador", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AvaliacaoDetalheTable, Integer> desempenho =
		createColumn(
			"desempenho", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private AvaliacaoDetalheTable() {
		super("DESAFIO_AvaliacaoDetalhe", AvaliacaoDetalheTable::new);
	}

}