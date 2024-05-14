package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBaseDAO {

    private static Connection conexao = null;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(driver);

                String server = "localhost";
                String database = "db_a3";
                String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
                String user = "root";
                String password = "Unisul@1520";

                conexao = DriverManager.getConnection(url, user, password);

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
}
