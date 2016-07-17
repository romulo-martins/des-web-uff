
/* Inserção de Clientes */
INSERT INTO Cliente(id, nome, email, telefone, data_nascimento) VALUES(1, 'Joao', 'joao@hotmail.com', '(21)9784-5589', '15/08/1957');
INSERT INTO Cliente(id, nome, email, telefone, data_nascimento) VALUES(2, 'Maria', 'mari@gmail.com', '(11)9841-7795', '03/04/1992');
INSERT INTO Cliente(id, nome, email, telefone, data_nascimento) VALUES(3, 'Ana', 'aninha@yahoo.com', '(19)6588-1910', '07/11/1995');
INSERT INTO Cliente(id, nome, email, telefone, data_nascimento) VALUES(4, 'Paulo', 'paulinho@hotmail.com', '(21)6798-4486', '23/04/1986');
INSERT INTO Cliente(id, nome, email, telefone, data_nascimento) VALUES(5, 'Fatima', 'fatinha@hotmail.com', '(11)8956-2367', '05/06/1994');

/* Inserção de Usuarios */
INSERT INTO Usuario(id, uname, password, cliente_id) VALUES(1, 'ujoao', '123456', 1);
INSERT INTO Usuario(id, uname, password, cliente_id) VALUES(2, 'umaria', '123456', 2);
INSERT INTO Usuario(id, uname, password, cliente_id) VALUES(3, 'uana', '123456', 3);
INSERT INTO Usuario(id, uname, password, cliente_id) VALUES(4, 'upaulo', '123456', 4);
INSERT INTO Usuario(id, uname, password, cliente_id) VALUES(5, 'ufatima', '123456', 5);



/* Inserção de exemplos de histórico */
INSERT INTO Historico(id, data_compra, valor_compra, cliente_id) VALUES(1, '18/09/2001', 2.300, 1);
INSERT INTO Historico(id, data_compra, valor_compra, cliente_id) VALUES(2, '07/11/2006', 3.700, 1);
INSERT INTO Historico(id, data_compra, valor_compra, cliente_id) VALUES(3, '20/07/2012', 300, 3);
INSERT INTO Historico(id, data_compra, valor_compra, cliente_id) VALUES(4, '04/08/2011', 250, 3);


/* Inserção de */
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(1, 'JOE SATRIANI', 'Show', '07/12/2016', '21h00', 'Espaço das Américas, Rua Tagipuru, 795 - Barra Funda, São Paulo - SP');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(2, 'ANGRA', 'Show', '13/09/2016', '21h00', 'Tom Brasil, Rua Bragança Paulista, 1281 - Chacara Santo Antonio São Paulo - SP');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(3, 'AEROSMITH', 'Show', '15/07/2016', '22h00','Rua Palestra Itália, 1800 - Barra Funda, São Paulo - SP');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(4, 'MATANZA FEST', 'Show', '23/07/2016', '22h00', 'Circo Voador, Rua dos Arcos, 0 - Rio de Janeiro - RJ');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(5, 'SIMPLE PLAN', 'Show', '19/12/2016', '22h30', 'Circo Voador, Rua dos Arcos, 0 - Rio de Janeiro - RJ');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(6, 'THE SISTERS OF MERCY', 'Show', '16/10/2016', '21h45', 'Tom Brasil, Rua Bragança Paulista, 1281 - Chacara Santo Antonio, São Paulo - SP');
INSERT INTO Evento(id, nome, descricao, data, hora, local) VALUES(7, 'A COR DO SOM', 'Show', '10/8/2016', '21h00', 'Teatro Bradesco, Rua Palestra Itália, Perdizes, São Paulo - SP');


/* Inserção de Endereços */
INSERT INTO Enderecos(rua, bairro, cidade, estado, complemento) VALUES('Rua Bragança Paulista, 1281', 'Chacara Santo Antonio', 'São Paulo', 'SP', 'Tom Brasil');
INSERT INTO Enderecos(rua, bairro, cidade, estado, complemento) VALUES('Rua Palestra Itália, 1800', 'Barra Funda', 'São Paulo', 'SP', 'Allianz Parque');
INSERT INTO Enderecos(rua, bairro, cidade, estado, complemento) VALUES('Avenida Imperatriz Leopoldina, 550', '', 'São Paulo', 'SP', 'Teatro UMC');

