

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


-- INSERINDO DADOS NA TABELA BASE DE COMPRAS
INSERT INTO base_compras (nome, valor) VALUES ('Arma', '100');
INSERT INTO base_compras (nome, valor) VALUES ('Munição', '30');
INSERT INTO base_compras (nome, valor) VALUES ('Água', '5');
INSERT INTO base_compras (nome, valor) VALUES ('Comida', '15');

SELECT * FROM reports r  ;
SELECT * FROM rebeldes WHERE id_rebelde = ORDER BY id_rebelde ;
SELECT * FROM inventario_rebeldes;

-- SELECIONANDO INVENTARIO DE REBELDE ESPECÍFICO
SELECT rebeldes.id_rebelde, base_compras.nome  
FROM rebeldes 
INNER JOIN inventario_rebeldes
ON rebeldes.id_rebelde = inventario_rebeldes.rebelde_id 
INNER JOIN base_compras 
ON inventario_rebeldes.item_id = base_compras.id_item 
WHERE rebeldes.id_rebelde = '2'

-- SELECIONANDO QUANTIDADE DE TRAIDORES E REBELDES
SELECT count(traidor) AS qtd_rebeldes FROM rebeldes WHERE traidor IS FALSE; 
SELECT count(traidor) AS qtd_traidores FROM rebeldes WHERE traidor IS TRUE; 

