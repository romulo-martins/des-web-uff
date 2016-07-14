
/* criação de clientes */
CREATE TABLE Cliente (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    nome VARCHAR(40),
    email VARCHAR(40), 
    telefone VARCHAR(40),
    data_nascimento VARCHAR(40),
    PRIMARY KEY (id)
);

/* criação de eventos */
CREATE TABLE Evento (
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),	
    nome VARCHAR(40),
    descricao VARCHAR(100),
	data VARCHAR(20),
	hora VARCHAR(20),
	local VARCHAR(40),
    PRIMARY KEY (id)
);

/* criação de ingresso */
CREATE TABLE Ingresso(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	valor DOUBLE,
	evento_id INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY(evento_id) REFERENCES evento(id)
);

CREATE TABLE Compra (
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	valor_total DOUBLE,
	PRIMARY KEY(id)
);

/* Não precisa por enquanto */
CREATE TABLE Endereco(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	rua VARCHAR(40),
	bairro VARCHAR(40),
	cidade VARCHAR(40),
	estado VARCHAR(40),
	complemento VARCHAR(40),
	PRIMARY KEY(id)
);


