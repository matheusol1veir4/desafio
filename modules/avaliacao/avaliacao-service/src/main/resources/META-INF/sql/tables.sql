create table DESAFIO_Avaliacao (
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	avaliacaoId LONG not null primary key,
	funcionarioId LONG,
	dataAvaliacao DATE null,
	periodoDesafio INTEGER,
	observacoesGerais VARCHAR(500) null,
	areaAtuacao INTEGER
);

create table DESAFIO_AvaliacaoDetalhe (
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	avaliacaoDetalheId LONG not null primary key,
	avaliacaoId LONG,
	tipoAvaliador INTEGER,
	nomeAvaliador VARCHAR(75) null,
	observacoesAvaliador VARCHAR(75) null,
	desempenho INTEGER
);

create table FOO_Avaliacoes (
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	avaliacoesId LONG not null primary key,
	descricaoDesafioId LONG,
	tipoAvaliador VARCHAR(75) null,
	nomeAvaliador VARCHAR(75) null,
	observacoesAvaliador VARCHAR(75) null,
	desempenho INTEGER
);

create table FOO_DescricaoDesafio (
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	descricaoDesafioId LONG not null primary key,
	funcionarioId LONG,
	dataAvaliacao DATE null,
	tipoDesafio INTEGER,
	observacoesGerais VARCHAR(75) null
);

create table FOO_Funcionario (
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	funcionarioId LONG not null primary key,
	nome VARCHAR(75) null,
	email VARCHAR(75) null,
	areaAtuacao INTEGER
);