package dao;

import modelo.Relatorio;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe responsável pela manipulação de dados dos relatórios no banco de dados.
 */
public class RelatorioDAO {

    private ArrayList<Relatorio> minhaLista = new ArrayList<>();
    private ConexaoDataBaseDAO db;

    /**
     * Construtor da classe RelatorioDAO. Inicializa a conexão com o banco de dados.
     */
    public RelatorioDAO() {
        this.db = new ConexaoDataBaseDAO();
    }

    /**
     * Retorna a lista de todos os relatórios.
     *
     * @return - Retorna a lista de relatórios.
     */
    public ArrayList<Relatorio> getTotais() {
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo, f.preco AS preco " +
                       "FROM tb_emprestimos e " +
                       "JOIN tb_amigos a ON e.id_amigo = a.id " +
                       "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
                       "ORDER BY nome_amigo;";
        return getRelatorio(query);
    }

    /**
     * Retorna a lista de relatórios de empréstimos atrasados.
     *
     * @return - Retorna a lista de relatórios de empréstimos atrasados.
     */
    public ArrayList<Relatorio> getAtrasados() {
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo, f.preco AS preco " +
                       "FROM tb_emprestimos e " +
                       "JOIN tb_amigos a ON e.id_amigo = a.id " +
                       "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
                       "WHERE e.data_limite < NOW() " +
                       "ORDER BY nome_amigo;";
        return getRelatorio(query);
    }

    /**
     * Retorna a lista de relatórios de empréstimos ativos.
     *
     * @return - Retorna a lista de relatórios de empréstimos ativos.
     */
    public ArrayList<Relatorio> getAtivos() {
        String query = "SELECT a.nome AS nome_amigo, f.nome AS nome_ferramenta, a.telefone AS telefone_amigo, f.preco AS preco " +
                       "FROM tb_emprestimos e " +
                       "JOIN tb_amigos a ON e.id_amigo = a.id " +
                       "JOIN tb_ferramentas f ON e.id_ferramenta = f.id " +
                       "WHERE e.data_limite >= NOW() " +
                       "ORDER BY nome_amigo;";
        return getRelatorio(query);
    }

    /**
     * Executa uma consulta SQL e preenche a lista de relatórios.
     *
     * @param query - A consulta SQL a ser executada.
     * @return - Retorna a lista de relatórios.
     */
    private ArrayList<Relatorio> getRelatorio(String query) {
        minhaLista.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()) {
                String amigoNome = res.getString("nome_amigo");
                String ferramentaNome = res.getString("nome_ferramenta");
                String telefone = res.getString("telefone_amigo");
                Double preco = res.getDouble("preco");
                Relatorio objeto = new Relatorio(amigoNome, ferramentaNome, telefone, preco);
                minhaLista.add(objeto);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }
}
