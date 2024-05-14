#o comando abaixo cria o database chamado db_A3
CREATE DATABASE IF NOT EXISTS db_A3;

#o comando abaixo acessa o database db_A3
USE db_A3;

#o comando abaixo remove a tabela para recriá-la
DROP TABLE IF EXISTS tb_ferramentas;

#o comando abaixo cria a tabela de tb_ferramentas
CREATE TABLE tb_ferramentas (
id INTEGER NOT NULL,
ferramenta VARCHAR(100),
marca VARCHAR(50),
preco DOUBLE,
PRIMARY KEY(id)
);

#o comando abaixo acessa o database db_A3
USE db_A3;

#o comando abaixo remove a tabela para recriá-la
DROP TABLE IF EXISTS tb_amigos;

#o comando abaixo cria a tabela de tb_amigos
CREATE TABLE tb_amigos (
id INTEGER NOT NULL,
nome VARCHAR(100),
telefone VARCHAR(50),
PRIMARY KEY(id)
);
