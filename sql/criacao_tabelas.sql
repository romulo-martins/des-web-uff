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

/* criação de clientes */
CREATE TABLE Cliente (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(40),
    email VARCHAR(40), 
    telefone VARCHAR(40),
    data_nascimento VARCHAR(40),
    PRIMARY KEY (id)
);

/* criação de usuários  */
CREATE TABLE Usuario(
	id INTEGER NOT NULL AUTO_INCREMENT,
	uname VARCHAR(40),
	password VARCHAR(40),
	cliente_id INTEGER, 
	PRIMARY KEY(id),
	FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE Evento (
    id INTEGER NOT NULL AUTO_INCREMENT,	
    nome VARCHAR(40),
    descricao VARCHAR(100),
	data_evento VARCHAR(40),
	hora VARCHAR(20),
	imagem VARCHAR(40),
	endereco_id INTEGER,
    PRIMARY KEY (id),
	FOREIGN KEY(endereco_id) REFERENCES Endereco(id)
);

CREATE TABLE Historico (
	id INTEGER NOT NULL AUTO_INCREMENT,
	data_compra VARCHAR(40),
	valor_compra DOUBLE, /* valor total da compra */
	cod_compra INTEGER,
	cliente_id INTEGER NOT NULL,
	PRIMARY KEY(id), 
	FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE ingresso(
	id INTEGER AUTO_INCREMENT,
	valor_pago DOUBLE,
	tipo_evento INTEGER, /* meia ou inteira */
	cod_compra INTEGER,
	evento_id INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY(evento_id) REFERENCES evento(id)
);

CREATE TABLE ingresso_factory(
	id INTEGER AUTO_INCREMENT,
	valor_ingresso DOUBLE,
	quantidade_ingressos INTEGER,
	evento_id INTEGER,
	PRIMARY KEY(id)
);

/* AUTO_INCREMENT no derby é GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) */
