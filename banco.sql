-- Criar banco de dados e utilizar
CREATE DATABASE db_a3;
USE db_a3;

-- Criar tabelas
CREATE TABLE tb_amigos (
    id_amigo INT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);

CREATE TABLE tb_emprestimos (
    id_emprestimo INT NOT NULL PRIMARY KEY,
    id_amigo INT NOT NULL,
    id_ferramenta INT,
    data_emprestimo TIMESTAMP DEFAULT NOW() NOT NULL,
    data_devolucao DATE,
    entregue BOOLEAN NOT NULL,
    data_finalizado DATE
);

CREATE TABLE tb_ferramentas (
    id_ferramenta INT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    preco DECIMAL(7,2) NOT NULL,
    id_emprestimo INT,
    FOREIGN KEY (id_emprestimo) REFERENCES tb_emprestimos (id_emprestimo)
);

-- Adicionar chaves estrangeiras
ALTER TABLE tb_emprestimos ADD CONSTRAINT fk_id_amigo FOREIGN KEY (id_amigo) REFERENCES tb_amigos (id_amigo);
ALTER TABLE tb_emprestimos ADD CONSTRAINT fk_id_ferramenta FOREIGN KEY (id_ferramenta) REFERENCES tb_ferramentas (id_ferramenta);

-- Inserir dados na tabela tb_amigos
INSERT INTO tb_amigos (id_amigo, nome, telefone) VALUES 
   (1, 'Bruno', '(48) 999809866'),
   (2, 'Julia', '(48) 996325897');

-- Inserir dados na tabela tb_ferramentas
INSERT INTO tb_ferramentas (id_ferramenta, nome, marca, preco) VALUES 
   (1, 'Martelo', 'Tramontina', 29.99),
   (2, 'Chave de Fenda', 'Bosch', 15.49);

-- Inserir dados na tabela tb_emprestimos
INSERT INTO tb_emprestimos (id_emprestimo, id_amigo, id_ferramenta, data_emprestimo, data_devolucao, entregue) VALUES 
   (1, 1, 1,'2024-05-30', '2024-06-03', false),
   (2, 2, 2,'2024-05-27', '2024-06-04', false);

-- Consultar a tabela tb_amigos
SELECT * FROM tb_amigos;

-- Consultar a tabela tb_emprestimos
SELECT * FROM tb_emprestimos;

-- Consultar a tabela tb_ferramentas
SELECT * FROM tb_ferramentas;
