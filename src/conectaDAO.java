
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        public static Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ leiloesGit ", 
                    "root", 
                    "ayla0702"
            );
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
}
