# Projeto A3 Unisul primeira fase

## Contextualização
- Esta é uma versão do sistema para a IDE NetBeans.
- O projeto no NetBeans deve ser chamado A3EmprestimosFerramentas.
- Os dados estão armazenados no banco de dados MySQL.
- Este programa possui diversas classes organizada nos pacotes principal, modelo, visao e dao.
- A pasta src contêm os fontes do projeto.
- A interface gráfica foi construída com o auxílio da IDE NetBeans.

## Objetivo 
- O objetivo desse trabalho é de demonstrar conhecimento em desenvolver habilidades básicas sobre programação, resolvendo problemas e criando soluções para alcançar os objetivos propostos.

## Problema
- No churrasco de família, seu tio-avô, lhe pediu um software para gerenciar o empréstimo de
ferramentas. Ele quer o software que rode localmente no computador dele. A ideia é ter um cadastro de
ferramentas (nome, marca, custo de aquisição) e o de amigos (nome, telefone).
Ele gostaria de registrar os empréstimos de uma ou mais ferramentas a um determinado amigo,
marcando a data que ocorreu e também a data de devolução.
Ele pediu que o software tenha um relatório de ferramentas e o quanto ele gastou. Também vai
querer outro relatório dos empréstimos ativos e de todos os empréstimos realizados, por algum motivo ele
gostaria de saber quem é que fez mais empréstimos e se tem alguém que nunca devolveu, inclusive, a cada
novo empréstimo ele gostaria de o sistema diga se o amigo ainda tem algo que não devolveu.

## Requisitos funcionais
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

## Requisitos não funcionais
- RNF01 - Localização: O software deve ser executado localmente no computador do
usuário, sem necessidade de conexão com a internet.
- RNF02 - Interface Amigável: O software deve ter uma interface fácil de usar e intuitiva,
adequada para usuários não técnicos, como o tio-avô.
- RNF03 - Segurança: O software deve garantir a segurança dos dados cadastrados,
protegendo informações pessoais e financeiras dos usuários.

## Banco de dados
- Abaixo o script para a criação do banco de dados e da tabela

[Script BD](https://github.com/ThuysaLuvison/A3EmprestimosFerramentas/blob/master/banco.sql)
- Usuario: root
- Senha: Unisul@1520

## Desenvolvedores
- Bruno Hudson Siebert Costa (BHSC1, 1072410978)
- João Pedro Farias da Silva (jumplyon, 1072413105)
- Thuysa Monique Luvison da Rosa (thuys)
- Tulio Anesio da Rosa (Tulio, tulioanesio, 1072410483)

