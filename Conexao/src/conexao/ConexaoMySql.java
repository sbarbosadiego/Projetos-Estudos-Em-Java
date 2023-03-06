
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Barbosa
 */
public class ConexaoMySql {
        
        Connection connection = null;
        
        final String usuario = "root";
        final String senha = "privada3";
        
        
        private String url() {
            String host = "localhost";
            String porta = "3306";
            String database = "escola";
            String url = "jdbc:mysql://"+host+":"+porta+"/"+database+"?serverTimezone=UTC";
            return url;
        }
        
        public Connection conectar() {
            try {
                // Carrega o driver do JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Conecta no banco de dados
                Connection conexao = DriverManager.getConnection(
                        this.url(), // URL do banco de dados
                        usuario, // Usuário do banco de dados
                        senha); // Senha do banco de dados
                
                // Cria base de dados
                Statement statement = conexao.createStatement();
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS escola;");
            } catch (ClassNotFoundException | SQLException erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
                return null;
            }
            return connection;
        }
        
}
