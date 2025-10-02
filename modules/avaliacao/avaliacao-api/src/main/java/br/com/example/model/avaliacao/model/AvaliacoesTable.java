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
 * The table class for the &quot;FOO_Avaliacoes&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Avaliacoes
 * @generated
 */
public class AvaliacoesTable extends BaseTable<AvaliacoesTable> {

	public static final AvaliacoesTable INSTANCE = new AvaliacoesTable();

	public final Column<AvaliacoesTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Long> avaliacoesId = createColumn(
		"avaliacoesId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AvaliacoesTable, Long> descricaoDesafioId =
		createColumn(
			"descricaoDesafioId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, String> tipoAvaliador = createColumn(
		"tipoAvaliador", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, String> nomeAvaliador = createColumn(
		"nomeAvaliador", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, String> observacoesAvaliador =
		createColumn(
			"observacoesAvaliador", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AvaliacoesTable, Integer> desempenho = createColumn(
		"desempenho", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private AvaliacoesTable() {
		super("FOO_Avaliacoes", AvaliacoesTable::new);
	}

}