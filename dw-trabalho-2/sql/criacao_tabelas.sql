CREATE TABLE Clientes(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    nome VARCHAR(40),
    email VARCHAR(40), 
    telefone VARCHAR(40),
    data_nascimento VARCHAR(40),
    endereco_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (endereco_id) REFERENCES Enderecos(id)
);

CREATE TABLE Enderecos(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	rua VARCHAR(40),
	bairro VARCHAR(40),
	cidade VARCHAR(40),
	cep VARCHAR(40),
	estado VARCHAR(40),
	pais VARCHAR(40),
	complemento VARCHAR(40),
	PRIMARY KEY(id)
);

CREATE TABLE Eventos(
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    nome VARCHAR(40),
    descricao VARCHAR(100),
    endereco_id INTEGER NOT NULL,
    ingresso_id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY(endereco_id) REFERENCES Enderecos(id),
    FOREIGN KEY(ingresso_id) REFERENCES Ingresso(id)    
);
