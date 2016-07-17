/* Propostas para mostrar pro pessoal*/

CREATE TABLE Evento (
    id INTEGER NOT NULL AUTO_INCREMENT,	
    nome VARCHAR(40),
    descricao VARCHAR(100),
	data_eveto DATE,
	hora VARCHAR(20),
	local_evento VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE Historico (
	id INTEGER NOT NULL AUTO_INCREMENT,
	data_compra DATE,
	valor_compra DOUBLE, /* valor total da compra */
	cod_compra INTEGER,
	cliente_id INTEGER NOT NULL,
	PRIMARY KEY(id), 
	FOREIGN KEY(cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE ingresso(
	id INTEGER AUTO_IMCREMENT,
	valor DOUBLE,
	tipo INTEGER, /* meia ou inteira */
	cod_compra INTEGER,
	evento_id INTEGER,
	PRIMARY KEY(id),
	FOREIGN KEY(evento_id) REFERENCES evento(id)
);
