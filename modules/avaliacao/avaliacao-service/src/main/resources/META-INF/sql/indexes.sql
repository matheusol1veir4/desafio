create index IX_512F5678 on DESAFIO_Avaliacao (areaAtuacao);
create unique index IX_CA07164C on DESAFIO_Avaliacao (funcionarioId, periodoDesafio);
create index IX_292AA7E0 on DESAFIO_Avaliacao (periodoDesafio);

create unique index IX_E5DEBAF1 on DESAFIO_AvaliacaoDetalhe (avaliacaoId, tipoAvaliador);

create unique index IX_BD7EC4F7 on FOO_Avaliacoes (descricaoDesafioId, tipoAvaliador[$COLUMN_LENGTH:75$]);
create index IX_C8431319 on FOO_Avaliacoes (groupId);

create index IX_C853693 on FOO_DescricaoDesafio (dataAvaliacao, dataAvaliacao);
create unique index IX_B784AAA6 on FOO_DescricaoDesafio (funcionarioId, tipoDesafio);
create index IX_DE3CFE57 on FOO_DescricaoDesafio (groupId);
create index IX_6F668E66 on FOO_DescricaoDesafio (tipoDesafio);

create index IX_1FA2652D on FOO_Funcionario (areaAtuacao);
create index IX_B0074764 on FOO_Funcionario (email[$COLUMN_LENGTH:75$]);
create index IX_F49AAAC2 on FOO_Funcionario (groupId);