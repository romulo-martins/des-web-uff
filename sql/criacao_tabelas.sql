
/* criação de usuários  */
CREATE TABLE Usuario(
	id INTEGER NOT NULL AUTO_INCREMENT,
	uname VARCHAR(40),
	password VARCHAR(40),
	cliente_id INTEGER, 
	PRIMARY KEY(id),
	FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
);

/* criação de clientes */
CREATE TABLE Cliente (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40),
    email VARCHAR(40), 
    telefone VARCHAR(40),
    data_nascimento VARCHAR(40),
    PRIMARY KEY (id)
);

/* tabela de historico */
CREATE TABLE Historico (
	id INTEGER NOT NULL AUTO_INCREMENT,
	data_compra VARCHAR(40),
	valor_total INTEGER,
	cliente_id INTEGER NOT NULL,
	PRIMARY KEY(id), 
	FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
);

/* criação de eventos */
CREATE TABLE Evento (
    id INTEGER NOT NULL AUTO_INCREMENT,	
    nome VARCHAR(40),
    descricao VARCHAR(100),
	data VARCHAR(20),
	hora VARCHAR(20),
	local VARCHAR(100),
    PRIMARY KEY (id)
);


/* criação de ingresso */
CREATE TABLE Ingresso(
	id INTEGER NOT NULL AUTO_INCREMENT,
	valor DOUBLE,
	evento_id INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY(evento_id) REFERENCES evento(id)
);

/* Não precisa por enquanto */
CREATE TABLE Endereco(
	id INTEGER NOT NULL AUTO_INCREMENT,
	rua VARCHAR(40),
	bairro VARCHAR(40),
	cidade VARCHAR(40),
	estado VARCHAR(40),
	complemento VARCHAR(40),
	PRIMARY KEY(id)
);

/* AUTO_INCREMENT no derby é GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) */
