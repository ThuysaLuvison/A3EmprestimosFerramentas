# Projeto A3 Unisul primeira fase

# Contextualização
- Esta é uma versão do sistema para a IDE NetBeans.
- O projeto no NetBeans deve ser chamado A3EmprestimosFerramentas.
- Os dados estão armazenados no banco de dados MySQL.
- Este programa possui diversas classes organizada nos pacotes principal, model, view e dao.
- A pasta src contêm os fontes do projeto.
- A interface gráfica foi construída com o auxílio da IDE NetBeans.

# Objetivo 
- O objetivo desse trabalho é de demonstrar conhecimento em desenvolver habilidades básicas sobre programação, resolvendo problemas e criando soluções para alcançar os objetivos propostos. 

# Requisitos funcionais
- RF01 - Cadastro de ferramentas: O software deve permitir que o usuário cadastre as
ferramentas, como nome, marca e custo.
- RF02 - Cadastro de amigos: O software deve permitir que o usuário cadastre os dados
dos amigos, como nome, e-mail e telefone.
- RF03 - Registro de empréstimos: O software deve permitir que o usuário registre os
empréstimos de ferramentas para os amigos, informando a ferramenta, o amigo, a
data do empréstimo e os dados previstos de devolução.
- RF04 - Registro de empréstimos: O software deve mostrar um aviso ao usuário a cada
novo empréstimo se a uma pendência de devolução.
- RF05 - Relatório de ferramentas: O software deve gerar um relatório com todas as
ferramentas cadastradas, informando a descrição e o valor de cada uma, bem como
o gasto total com a aquisição das ferramentas.
- RF06 - Relatório de empréstimos ativos: O software deve gerar um relatório com todos
os empréstimos que ainda não foram devolvidos, informando a ferramenta
emprestada, o amigo que pegou emprestado, a data de empréstimo e os dados
previstos de devolução.
- RF07 - Relatório de todos os empréstimos: O software deve gerar um relatório com
todos os empréstimos realizados, informando a ferramenta emprestada, o amigo que
pegou emprestado, a data de empréstimo e os dados de devolução e qual amigo faz
mais empréstimos.
- RF08 - Verificação de ferramentas não devolvidas: O software deve verificar a cada
novo empréstimo se o amigo ainda tem ferramentas não devolvidas e informar ao
usuário.

# Requisitos não funcionais
- RNF01 - Localização: O software deve ser executado localmente no computador do
usuário, sem necessidade de conexão com a internet.
- RNF02 - Interface Amigável: O software deve ter uma interface fácil de usar e intuitiva,
adequada para usuários não técnicos, como o tio-avô.
- RNF03 - Segurança: O software deve garantir a segurança dos dados cadastrados,
protegendo informações pessoais e financeiras dos usuários.

# Banco de dados
- Abaixo o script para a criação do banco de dados e da tabela
```
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
```

# Criadores
- Bruno Hudson Siebert Costa
- João Pedro Farias da Silva
- Thuysa Monique Luvison da Rosa
- Tulio Anesio da Rosa

