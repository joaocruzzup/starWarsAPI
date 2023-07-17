# 💫 Sistema de gerenciamento StarWars 💫

Repositório criado referente ao sistema de gerenciamento baseado em StarWars.

---

## 🛫 O que é o sistema?

O sistema de gerencimento StarWars foi criado para possibilitar as seguintes tasks:

🔸 Adicionar rebeldes: Um rebelde deve ter um nome, idade, gênero e localização(nome da base).  

🔸 Um rebelde também possui um inventário que deverá ser passado na requisição com os recursos em sua posse.  

🔸 Atualizar localização do rebelde: Um rebelde deve possuir a capacidade de reportar sua última localização, armazenando a nova base.  

🔸 Reportar o rebelde como um traidor: Eventualmente algum rebelde irá trair a resistência e se aliar ao império. Quando isso acontecer, nós precisamos informar que o rebelde é um traidor.  

🔸 Um rebelde é marcado como traidor quando, ao menos, três outros rebeldes reportarem a traição.  

🔸 Gerar Relatórios de quantidades de Traidores e Rebeldes  

🔸 Haver uma base de compras: Os rebeldes poderão comprar itens.  

🔸 Haver os seguintes Joins com o banco de dados: INNER-JOIN / LEFT-JOIN / RIGHT-JOIN / FULL-JOIN  


---

## 📱 Funcionalidades do Sistema

O Sistema conta como algumas funcionalidades, são elas:

- Navegação entre Menus (Menu de Rebeldes, Menu de Loja, Menu de Invetário, Menu de Relatórios)
- Conexão com banco de dados postgreSQL

---

## 🐘 Scripts SQL (PostgreSQL) utilizados

### 📲 Criação de Tabelas

Criando Tabelas Rebeldes: 
```
CREATE TABLE rebeldes (
id_rebelde SERIAL PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
idade INTEGER,
genero VARCHAR(100),
localizacao VARCHAR(250),
traidor BOOLEAN,
ativo BOOLEAN);
```

Criando Tabelas Reports: 
```
CREATE TABLE reports (
id_report SERIAL PRIMARY KEY,
denunciante_id INTEGER NOT NULL,
reportado_id INTEGER NOT NULL,
FOREIGN KEY (denunciante_id) REFERENCES rebeldes(id_rebelde),
FOREIGN KEY (reportado_id) REFERENCES rebeldes(id_rebelde));
```

Criando Tabelas Base_Compras: 
```
CREATE TABLE base_compras(
id_item SERIAL PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
valor decimal(10,2) NOT NULL);
```

Criando Tabelas Inventario_Rebeldes: 
```
CREATE TABLE base_compras(
id_item SERIAL PRIMARY KEY,
nome VARCHAR(250) NOT NULL,
valor decimal(10,2) NOT NULL);
```

### ➡️ Inserção de dados

Inserindo Dados na Tabela rebeldes: 
```
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Luke Skywalker', 30, 'Masculino', 'Tatooine', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Leia Organa', 28, 'Feminino', 'Alderaan', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Han Solo', 35, 'Masculino', 'Corellia', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Rey', 25, 'Feminino', 'Jakku', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Finn', 28, 'Masculino', 'Desconhecida', false, true);
INSERT INTO rebeldes (nome, idade, genero, localizacao, traidor, ativo) VALUES ('Poe Dameron', 32, 'Masculino', 'Yavin 4', false, true);
```

Inserindo Dados na Tabela base_compras: 
```
INSERT INTO base_compras (nome, valor) VALUES ('Arma', '100');
INSERT INTO base_compras (nome, valor) VALUES ('Munição', '30');
INSERT INTO base_compras (nome, valor) VALUES ('Água', '5');
INSERT INTO base_compras (nome, valor) VALUES ('Comida', '15');
```

Inserindo Dados na Tabela inventario_rebeldes:
```
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (1, 1); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (2, 2);
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (3, 3); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (4, 4); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (5, 1); 
INSERT INTO inventario_rebeldes (rebelde_id, item_id) VALUES (6, 2); 
```

Inserindo Dados na Tabela reports:
```
INSERT INTO reports (denunciante_id, reportado_id) VALUES (1, 2);
INSERT INTO reports (denunciante_id, reportado_id) VALUES (3, 4); 
INSERT INTO reports (denunciante_id, reportado_id) VALUES (5, 6);
```

### 🔀 Realização de JOINS nas tabelas:

INNER JOIN:
```
SELECT rebeldes.id_rebelde, base_compras.nome  
FROM rebeldes 
INNER JOIN inventario_rebeldes
ON rebeldes.id_rebelde = inventario_rebeldes.rebelde_id 
INNER JOIN base_compras 
ON inventario_rebeldes.item_id = base_compras.id_item 
WHERE rebeldes.id_rebelde = '2'
```

LEFT JOIN:
```
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
LEFT JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
LEFT JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;
```

RIGHT JOIN:
```
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
RIGHT JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
RIGHT JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;
```

FULL JOIN:
```
SELECT rebeldes.nome AS denunciante, rebeldes_1.nome AS reportado
FROM rebeldes
FULL JOIN reports ON rebeldes.id_rebelde = reports.denunciante_id
FULL JOIN rebeldes AS rebeldes_1 ON reports.reportado_id = rebeldes_1.id_rebelde;
```


## ⏯️ Como executar?

- Você precisará ter o [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11) instalado no seu computador;
- Baixe o repositório do projeto;
- Abra o terminal e navegue até o diretório do programa que você deseja executar;
- Compile o arquivo executando o comando `javac` no arquivo [Main](https://github.com/joaocruzzup/starWarsAPI/blob/main/src/main/java/org/example/Main.java):
```
javac Main.java
```
- Após compilar, execute o comando `java`, como mostra abaixo:
```
java Main.java
```

## 👨‍💻 Autor

Nome: João Cruz<br>Linkedin: https://www.linkedin.com/in/joaosilvacruz/

---

<h4 align=center>Made with 💚 by <a href="https://github.com/joaocruzzup">João Cruz</a></h4>
