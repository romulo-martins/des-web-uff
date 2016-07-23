/* Inserção de Endereços dos eventos */
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(1, 'Rua Tagipuru, 795', ' Barra Funda', 'São Paulo' ,'SP', 'Espaço das Américas');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(2, 'Rua Bragança Paulista, 1281',' Chacara Santo Antonio',' São Paulo', 'SP', 'Tom Brasil');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(3, 'Rua Palestra Itália, 1800', 'Barra Funda', 'São Paulo' ,'SP', '');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(4, 'Rua dos Arcos, 0', 'Lapa', 'Rio de Janeiro', 'RJ', 'Circo Voador');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(5, 'Rua dos Arcos, 0', 'Lapa', 'Rio de Janeiro', 'RJ', 'Circo Voador');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(6, 'Rua Bragança Paulista, 1281', 'Chacara Santo Antonio', 'São Paulo', 'SP', 'Tom Brasil');
INSERT INTO Endereco(id, rua, bairro, cidade, estado, complemento) VALUES(7, 'Rua Palestra Itália', 'Perdizes', 'São Paulo', 'SP', 'Teatro Bradesco');

/* Inserção de */
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(1, 'JOE SATRIANI', 'Show', '07/12/2016', '21h00', 'joe-satriani.jpg', 1);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(2, 'ANGRA', 'Show', '13/09/2016', '21h00', 'angra.jpg', 2);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(3, 'AEROSMITH', 'Show', '15/07/2016', '22h00', 'aerosmith.jpg', 3);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(4, 'MATANZA FEST', 'Show', '23/07/2016', '22h00', 'matanza.jpg', 4);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(5, 'SIMPLE PLAN', 'Show', '19/12/2016', '22h30', 'simple-plan.jpg', 5);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(6, 'THE SISTERS OF MERCY', 'Show', '16/10/2016', '21h45', 'the-sisters-of-mercy.jpg', 6);
INSERT INTO Evento(id, nome, descricao, data_evento, hora, imagem, endereco_id) VALUES(7, 'A COR DO SOM', 'Show', '10/8/2016', '21h00', 'a-cor-do-som.jpg', 7);


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



/* Insersão do valor dos preçõs dos ingressos e do estoque de ingressos de cada evento */
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (1, 250, 15000, 1);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (2, 180, 2500, 2);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (3, 375, 30000, 3);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (4, 120, 7300, 4);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (5, 190, 8000, 5);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (6, 160, 12000, 6);
INSERT INTO ingresso_factory(id, valor_ingresso, quantidade_ingressos, evento_id) VALUES (7, 90, 800, 7);

