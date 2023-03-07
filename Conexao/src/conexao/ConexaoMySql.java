package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Barbosa
 */
public class ConexaoMySql {

    private boolean status = false;
    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;

    private String servidor = "localhost";
    private String database = "dbalunoscurso";
    private String porta = "3306";
    private String usuario = "root";
    private String senha = "";

    public ConexaoMySql() {

    }

    public ConexaoMySql(String servidor, String database, String porta, String usuario, String senha) {
        this.servidor = servidor;
        this.database = database;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String url() {
        String url = "jdbc:mysql://" + this.getServidor() + ":" + this.getPorta() + "/" + this.database + "?serverTimezone=UTC";
        return url;
    }

    /**
     * Método que realiza a conexão ao banco de dados
     * @return connection
     */
    public Connection conectar() {
        try {
            // Carrega o driver do JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta no banco de dados
            this.setConnection((Connection) DriverManager.getConnection(
                    url(),
                    usuario,
                    senha));
            this.status = true;

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
            return null;
        }
        return connection;
    }
    
    /**
     * Método que encerra a conexão com o banco de dados
     * @return boolean
     */
    public boolean desconectar() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getConnection().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private Connection getConnection() {
        return connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private Statement getStatement() {
        return statement;
    }

    private void setStatement(Statement statement) {
        this.statement = statement;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
