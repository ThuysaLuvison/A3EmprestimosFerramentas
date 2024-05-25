package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

/**
 * Classe responsável pelo acesso aos dados dos amigos no banco de dados.
 * Fornece dados para carregar, inserir, atualizar e excluir amigos.
 *
 * @author joaopedrofariasdasilva
 */
public class AmigoDAO {

    /**
     * Lista de amigos carregados do banco de dados.
     */
    public ArrayList<Amigo> minhaLista = new ArrayList<>();

    /**
     * Objeto responsável pela conexão com o banco de dados.
     */
    private ConexaoDataBaseDAO db;

    /**
     * Construtor da classe AmigoDAO.
     *
     * Inicializa a conexão com o banco de dados.
     */
    public AmigoDAO() {
        this.db = new ConexaoDataBaseDAO();
    }

    /**
     * Retorna a lista de amigos do banco de dados.
     *
     * @return - ArrayList contendo objetos Amigo recuperados do banco de dados.
     *
     */
    public ArrayList<Amigo> getMinhaLista() {

        /**
         * Limpa nosso ArrayList.
         */
        minhaLista.clear();

        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(id, nome, telefone);

                minhaLista.add(objeto);
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

    /**
     * Define a lista de amigos. Substitui a lista atual de amigos por uma nova
     * lista fornecida como parâmetro.
     *
     * @param minhaLista
     */
    public void setMinhaLista(ArrayList<Amigo> minhaLista) {
        this.minhaLista = minhaLista;
    }

    /**
     * Retorna o maior ID presente na tabela de amigos.
     *
     * @return - Inteiro representando o maior ID.
     */
    public int maiorID() {
        int maiorID = 0;
        try {
            Statement stmt = db.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return maiorID;
    }

    /**
     * Cadastra novo amigo no banco de dados.
     *
     * @param objeto - Objeto Amigo a ser inserido.
     * @return - Boolean indicando se a operação foi bem-sucedida.
     */
    public boolean insertAmigoBD(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id,nome,telefone) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Exclui um amigo do banco de dados com base no ID.
     *
     * @param id - inteiro representando o ID do amigo a ser excluído.
     * @return - Boolean indicando se a operação foi bem-sucedida.
     */
    public boolean deleteAmigoBD(int id) {
        try {
            Statement stmt = db.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     *
     * @param objeto - Objeto Amigo com os dados atualizados.
     * @return - Boolean indicando se a operação foi bem-sucedida.
     */
    public boolean updateAmigoBD(Amigo objeto) {

        String sql = "UPDATE tb_amigos set nome = ? ,telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = db.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }

    /**
     * Carrega um amigo do banco de dados com base no ID.
     *
     * @param id - Representa o ID do amigo a ser carregado.
     * @return - Objeto Amigo com os dados do amigo carregado.
     */
    public Amigo carregaAmigo(int id) {
        Amigo objeto = new Amigo();
        objeto.setId(id);
        try {
            Statement stmt = db.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE id = " + id);
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
