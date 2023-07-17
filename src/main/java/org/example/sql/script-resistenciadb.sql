-- CRIANDO TABELA REBELDES
CREATE TABLE rebeldes (
id_rebelde SERIAL PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
idade INTEGER,
genero VARCHAR(100),
localizacao VARCHAR(250),
traidor BOOLEAN,
ativo BOOLEAN);

-- CRIANDO TABELA REPORTS
CREATE TABLE reports (
id_report SERIAL PRIMARY KEY,
denunciante_id INTEGER NOT NULL,
reportado_id INTEGER NOT NULL,
FOREIGN KEY (denunciante_id) REFERENCES rebeldes(id_rebelde),
FOREIGN KEY (reportado_id) REFERENCES rebeldes(id_rebelde));

-- CRIANDO TABELA BASE_COMPRAS
CREATE TABLE base_compras(
id_item SERIAL PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
valor decimal(10,2) NOT NULL);

-- CRIANDO TABELA INVENTARIO_REBELDES
CREATE TABLE inventario_rebeldes(
id_iventario SERIAL PRIMARY KEY,
rebelde_id INTEGER NOT NULL,
item_id INTEGER NOT NULL,
FOREIGN KEY (rebelde_id) REFERENCES rebeldes(id_rebelde),
FOREIGN KEY (item_id) REFERENCES base_compras(id_item));


-- INSERINDO DADOS NA TABELA REBELDES
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Luke Skywalker', 30, 'Masculino', 'Tatooine', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Leia Organa', 28, 'Feminino', 'Alderaan', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Han Solo', 35, 'Masculino', 'Corellia', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Rey', 25, 'Feminino', 'Jakku', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Finn', 28, 'Masculino', 'Desconhecida', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Poe Dameron', 32, 'Masculino', 'Yavin 4', false, true);

-- INSERINDO DADOS NA TABELA BASE DE COMPRAS
INSERT INTO base_compras (nome, valor) VALUES ('Arma', '100');
INSERT INTO base_compras (nome, valor) VALUES ('Munição', '30');
INSERT INTO base_compras (nome, valor) VALUES ('Água', '5');
INSERT INTO base_compras (nome, valor) VALUES ('Comida', '15');

-- INSERINDO DADOS NA TABELA INVENTARIO_REBELDES
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (1, 1); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (2, 2);
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (3, 3); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (4, 4); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (5, 1); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (6, 2); 

-- INSERINDO DADOS NA TABELA REPORTS
INSERT INTO reports (denunciante_id, reportado_id) VALUES (1, 2);
INSERT INTO reports (denunciante_id, reportado_id) VALUES (3, 4); 
INSERT INTO reports (denunciante_id, reportado_id) VALUES (5, 6); 

SELECT * FROM reports r  ;
SELECT * FROM rebeldes WHERE id_rebelde = ORDER BY id_rebelde ;
SELECT * FROM inventario_rebeldes;


-- SELECIONANDO QUANTIDADE DE TRAIDORES E REBELDES
SELECT count(traidor) AS qtd_rebeldes FROM rebeldes WHERE traidor IS FALSE; 
SELECT count(traidor) AS qtd_traidores FROM rebeldes WHERE traidor IS TRUE; 

-- UTILIZANDO OS JOINS NAS TABELAS
-- INNER JOIN -> SELECIONANDO INVENTARIO DE REBELDE ESPECÍFICO
SELECT rebeldes.id_rebelde, base_compras.nome  
FROM rebeldes 
INNER JOIN inventario_rebeldes
ON rebeldes.id_rebelde = inventario_rebeldes.rebelde_id 
INNER JOIN base_compras 
ON inventario_rebeldes.item_id = base_compras.id_item 
WHERE rebeldes.id_rebelde = '2'

-- LEFT JOIN -> SELECIONANDO TODOS DENUNCIANTES, MAS NEM TODOS REPORTADOS
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
LEFT JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
LEFT JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;

-- RIGHT JOIN -> SELECIONANDO TODOS REPORTADOS, MAS NEM TODOS DENUNCIANTES
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
RIGHT JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
RIGHT JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;

-- FULL JOIN -> SELECIONANDO TODOS REPORTADOS E TODOS DENUNCIANTES
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
FULL JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
FULL JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;