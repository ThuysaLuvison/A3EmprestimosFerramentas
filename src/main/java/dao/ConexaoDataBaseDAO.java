package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por estabelecer a conexão com o banco de dados.
 */
public class ConexaoDataBaseDAO {

    private static Connection conexao = null;

    /**
     * Retorna a conexão com o banco de dados.
     *
     * @return - Retorna a conexão com o banco de dados.
     */
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                /**
                 * Configurações de conexão com o banco de dados.
                 */
                String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(driver);

                String server = "localhost";
                String database = "db_a3";
                String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
                String user = "root";
                String password = "Unisul@1520";
                /**
                 * Estabelecendo conexão.
                 */
                conexao = DriverManager.getConnection(url, user, password);
                /**
                 * Verificando se a conexão foi estabelecida com sucesso.
                 */
                if (conexao != null) {
                    System.out.println("Status: Conectado!");
                } else {
                    System.out.println("Status: NÃO CONECTADO!");
                }
            } catch (ClassNotFoundException e) {
                System.out.println("O driver não foi encontrado. " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Não foi possível conectar...");
            }
        }
        return conexao;
    }

    public PreparedStatement prepareStatement(String query) {
        return null;
    }

}
