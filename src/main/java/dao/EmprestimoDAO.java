package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Emprestimo;

/**
 * Classe responsável pela interação com o banco de dados para operações
 * relacionadas a empréstimos.
 */
public class EmprestimoDAO {

    public ArrayList<String> FerSelect;

    /**
     * Lista de todos os empréstimos.
     */
    public static ArrayList<Emprestimo> ListaEmprestimos = new ArrayList<>();

    /**
     * Lista de empréstimos ativos.
     */
    public ArrayList<Emprestimo> ListaEmprestimosAtivos = new ArrayList<>();

    /**
     * Lista de empréstimos pendentes.
     */
    public ArrayList<Emprestimo> ListaEmprestimosPendentes = new ArrayList<>();

    /**
     * Lista de mais empréstimos.
     */
    ArrayList<String> usuarioComMaisEmprestimos = new ArrayList<>();

    /**
     * Conexão com o banco de dados.
     */
    private ConexaoDataBaseDAO connect;

    /**
     * Construtor da classe EmprestimoDAO que inicializa a conexão com o banco
     * de dados.
     */
    public EmprestimoDAO() {
        this.connect = new ConexaoDataBaseDAO();
    }

    /**
     * Método para obter a lista completa de empréstimos.
     *
     * @return - Lista de empréstimos.
     */
    public ArrayList<Emprestimo> getMinhaLista() {

        /**
         * Limpa a lista atual antes de preenchê-la.
         */
        ListaEmprestimos.clear();

        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter todos os empréstimos.
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos");

            /**
             * Itera sobre o resultado da consulta.
             */
            while (res.next()) {
                /**
                 * Obtém os dados de cada empréstimo do resultado.
                 */
                int id = res.getInt("id_emprestimo");
                int idAmg = res.getInt("id_amigo");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataDevolucao = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista.
                 */
                Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
                ListaEmprestimos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimos;
    }

    /**
     * Método para obter o maior ID de empréstimo presente no banco de dados.
     *
     * @return - Maior ID de empréstimo.
     */
    public int maiorId() {
        int maiorId = 0;
        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter o maior ID de empréstimo.
             */
            ResultSet res = stmt.executeQuery("SELECT MAX(id_emprestimo) id FROM tb_emprestimos");
            res.next();
            maiorId = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorId;
    }

    /**
     * Método para inserir um novo empréstimo no banco de dados.
     *
     * @param objeto - Objeto Emprestimo a ser inserido.
     * @return - Verdadeiro se a inserção for bem-sucedida, caso contrário,
     * falso.
     */
    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        /**
         * SQL para inserção de um novo empréstimo.
         */
        String sql = "INSERT INTO tb_emprestimos(id_emprestimo,id_amigo,data_emprestimo, data_devolucao, entregue) VALUES(?,?,?,?,?)";
        try {
            /**
             * Prepara o statement com a consulta SQL.
             */
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            /**
             * Define os parâmetros da consulta com os dados do empréstimo.
             */
            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getIdAmg());
            stmt.setDate(3, objeto.getDataEmprestimo());
            stmt.setDate(4, objeto.getDataDevolucao());
            stmt.setBoolean(5, objeto.isEntregue());

            /**
             * Executa a consulta SQL.
             */
            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Método para apagar um empréstimo do banco de dados.
     *
     * @param id - ID do empréstimo a ser apagado.
     * @return - Verdadeiro se a exclusão for bem-sucedida, caso contrário,
     * falso.
     */
    public boolean apagarEmprestimoBD(int id) {
        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para apagar o empréstimo com o ID
             * especificado.
             */
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE id_emprestimo = " + id);

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return true;
    }

    /**
     * Método para alterar os dados de um empréstimo no banco de dados.
     *
     * @param objeto - Objeto Emprestimo com os dados atualizados.
     * @return - Verdadeiro se a atualização for bem-sucedida, caso contrário,
     * falso.
     */
    public boolean alterarEmprestimoBD(Emprestimo objeto) {
        /**
         * SQL para atualizar os dados de um empréstimo.
         */
        String sql = "UPDATE tb_emprestimos set data_devolucao = ?, entregue = ? WHERE id_emprestimo = ?";
        try {
            /**
             * Prepara o statement com a consulta SQL.
             */
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            /**
             * Define os parâmetros da consulta com os dados atualizados do
             * empréstimo.
             */
            stmt.setDate(1, objeto.getDataDevolucao());
            stmt.setBoolean(2, objeto.isEntregue());
            stmt.setInt(3, objeto.getId());

            /**
             * Executa a consulta SQL.
             */
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Método para carregar os dados de um empréstimo do banco de dados.
     *
     * @param id - ID do empréstimo a ser carregado.
     * @return - Objeto Emprestimo com os dados carregados.
     */
    public Emprestimo carregarEmprestimoBD(int id) {
        /**
         * Cria um objeto Emprestimo para armazenar os dados carregados.
         */
        Emprestimo objeto = new Emprestimo();
        objeto.setId(id);
        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os dados do empréstimo com o ID
             * especificado.
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE id_emprestimo = " + id);
            res.next();

            /**
             * Preenche o objeto Emprestimo com os dados obtidos do banco de
             * dados.
             */
            objeto.setIdAmg(res.getInt("id_amigo"));
            objeto.setDataEmprestimo(res.getDate("data_emprestimo"));
            objeto.setDataDevolucao(res.getDate("data_devolucao"));
            objeto.setEntregue(res.getBoolean("entregue"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }

    /**
     * Método para obter a lista de empréstimos ativos.
     *
     * @return - Lista de empréstimos ativos.
     */
    public ArrayList<Emprestimo> getEmprestimosAtivos() {

        /**
         * Limpa a lista atual antes de preenchê-la.
         */
        ListaEmprestimosAtivos.clear();

        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os empréstimos que ainda não
             * foram entregues.
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE data_devolucao >= NOW() AND entregue = FALSE;");

            /**
             * Itera sobre o resultado da consulta.
             */
            while (res.next()) {
                /**
                 * Obtém os dados de cada empréstimo do resultado.
                 */
                int id = res.getInt("id_emprestimo");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataDevolucao = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");
                int idAmg = res.getInt("id_amigo");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos ativos.
                 */
                Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
                ListaEmprestimosAtivos.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimosAtivos;
    }

    /**
     * Método para verificar se um empréstimo específico ainda está pendente.
     *
     * @param id - ID do empréstimo a ser verificado.
     * @return - Verdadeiro se o empréstimo ainda estiver pendente, caso
     * contrário, falso.
     */
    public boolean verificarPendencia(int id) {

        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os empréstimos.
             */
            ResultSet res = stmt.executeQuery("SELECT id_emprestimo, entregue FROM tb_emprestimos");

            /**
             * Itera sobre o resultado da consulta.
             */
            while (res.next()) {
                /**
                 * Obtém os dados de cada empréstimo do resultado.
                 */
                int idEmp = res.getInt("id_emprestimo");
                boolean entregue = res.getBoolean("entregue");

                /**
                 * Verifica se o empréstimo com o ID especificado ainda não foi
                 * entregue.
                 */
                if (idEmp == id && !entregue) {
                    return true; // Retorna que o empréstimo ainda está ativo.
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return false;
    }

    /**
     * Método para alterar o ID do empréstimo na tabela de ferramentas quando
     * pendente.
     *
     * @param id - ID do empréstimo a ser alterado.
     * @return - Verdadeiro se a alteração for bem-sucedida, caso contrário,
     * falso.
     */
    public boolean alterarIdEmpFerramentaPendente(int id) {
        String sql = "UPDATE tb_ferramentas SET id_emprestimo = null WHERE id_emprestimo = ?";
        try {
            PreparedStatement stmt = connect.getConexao().prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.execute();

            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Método para obter a lista de empréstimos pendentes.
     *
     * @return Lista de empréstimos pendentes.
     */
    public ArrayList<Emprestimo> getEmprestimosPendentes() {

        /**
         * Limpa a lista atual antes de preenchê-la.
         */
        ListaEmprestimosPendentes.clear();

        try {
            /**
             * Cria um statement para executar a consulta.
             */
            Statement stmt = connect.getConexao().createStatement();

            /**
             * Executa a consulta SQL para obter os empréstimos que ainda não
             * foram entregues e estão atrasados.
             */
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE data_devolucao < NOW() and entregue = FALSE");

            /**
             * Itera sobre o resultado da consulta.
             */
            while (res.next()) {
                /**
                 * Obtém os dados de cada empréstimo do resultado.
                 */
                int id = res.getInt("id_emprestimo");
                Date dataEmprestimo = res.getDate("data_emprestimo");
                Date dataDevolucao = res.getDate("data_devolucao");
                boolean entregue = res.getBoolean("entregue");
                int idAmg = res.getInt("id_amigo");

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos pendentes.
                 */
                Emprestimo objeto = new Emprestimo(dataEmprestimo, dataDevolucao, entregue, id, idAmg);
                ListaEmprestimosPendentes.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return ListaEmprestimosPendentes;
    }

    /**
     * Método para calcular o valor total de todas as ferramentas.
     *
     * @return - Valor total formatado como String.
     */
    public String valorTotal() {
        double soma = 0;

        try {
            String query = "SELECT SUM(preco) FROM tb_ferramentas";
            PreparedStatement statement = connect.getConexao().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                soma = resultSet.getDouble(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return String.format("%.2f", soma);
    }

    public ArrayList<String> getUsuarioComMaisEmprestimos() {

        usuarioComMaisEmprestimos.clear();
        /**
         * Limpa a lista atual antes de preenchê-la
         */
        try {
            /**
             * Cria um statement para executar a consulta
             */
            Statement stmt = connect.getConexao().createStatement();
            /**
             * Executa a consulta SQL para obter os empréstimos que ainda não
             * foram entregues
             */
            ResultSet res = stmt.executeQuery(" SELECT a.nome, a.telefone\n"
                    + "	FROM tb_amigos a\n"
                    + "	JOIN (\n"
                    + "      SELECT e.id_amigo, COUNT(e.id_amigo) AS total_emprestimos\n"
                    + "      FROM tb_emprestimos e\n"
                    + "      GROUP BY e.id_amigo\n"
                    + "	) AS emprestimos_por_amigo ON a.id_amigo = emprestimos_por_amigo.id_amigo\n"
                    + "	ORDER BY emprestimos_por_amigo.total_emprestimos DESC\n"
                    + "     LIMIT 1;");
            /**
             * Itera sobre o resultado da consulta
             */
            while (res.next()) {

                /**
                 * Obtém os dados de cada empréstimo do resultado
                 */
                String nomeAmigo = res.getString("nome");
                String telefone = res.getString("telefone");

                usuarioComMaisEmprestimos.add(nomeAmigo);
                usuarioComMaisEmprestimos.add(telefone);

                /**
                 * Cria um objeto Emprestimo com os dados obtidos e o adiciona à
                 * lista de empréstimos ativos
                 */
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return usuarioComMaisEmprestimos;
    }
}
