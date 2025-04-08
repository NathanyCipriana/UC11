
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conectaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/leiloesgit";
    private static final String USER = "root";
    private static final String PASS = "ayla0702";

    public static Connection connectDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return conn;
    }

}
