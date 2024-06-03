#o comando abaixo cria o database chamado db_a3
CREATE DATABASE IF NOT EXISTS db_a3;

#o comando abaixo acessa o database db_a3
USE db_a3;

#o comando abaixo remove a tabela para recriá-la
DROP TABLE IF EXISTS tb_amigos;

#o comando abaixo cria a tabela de tb_amigos
CREATE TABLE tb_amigos (
	id INT NOT NULL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(15) NOT NULL
);

#o comando abaixo acessa o database db_A3
USE db_a3;

#o comando abaixo remove a tabela para recriá-la
DROP TABLE IF EXISTS tb_ferramentas;

#o comando abaixo cria a tabela de tb_ferramentas
CREATE TABLE tb_ferramentas (
	id INT NOT NULL PRIMARY KEY,
	ferramenta VARCHAR(50) NOT NULL,
	marca VARCHAR(50) NOT NULL,
	preco DECIMAL(7 , 2 ) NOT NULL
);

#o comando abaixo acessa o database db_a3
USE db_a3;

#o comando abaixo remove a tabela para recriá-la
DROP TABLE IF EXISTS tb_emprestimos;

#o comando abaixo cria a tabela de tb_emprestimos
CREATE TABLE tb_emprestimos (
	id INT NOT NULL PRIMARY KEY,
	id_amigo INT NOT NULL,
	id_ferramenta INT NOT NULL,
	data_emprestimo TIMESTAMP DEFAULT NOW() NOT NULL,
	data_limite DATE,
	FOREIGN KEY (id_amigo) REFERENCES tb_amigos (id),
	FOREIGN KEY (id_ferramenta) REFERENCES tb_ferramentas (id)
);

