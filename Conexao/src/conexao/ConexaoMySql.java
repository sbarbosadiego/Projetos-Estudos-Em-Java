package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class ConexaoMySql {

    private boolean status = false;
    private Connection connection = null;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private String servidor = "localhost";
    private String database = "";
    private String porta = "3306";
    private String usuario = "root";
    private String senha = "privada3";

    public ConexaoMySql() {

    }

    public ConexaoMySql(String servidor, String database, String porta, String usuario, String senha) {
        this.servidor = servidor;
        this.database = database;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
    }

    private String url() {
        String url = "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.database + "?serverTimezone=UTC";
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
                    this.url(),
                    this.usuario,
                    this.senha));
            this.configurarBanco(connection);
            this.status = true;

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
    
    /**
     * Método que inseri um novo registro no banco de dados
     * @param sql
     * @return int
     */
    public int insertSql(String sql) {
        int status = 0;
        System.out.println(status);
        try {
            // Seta o stament com o getConnection que chama o prepareStatement
            this.setPreparedStatement(this.getConnection().prepareStatement(sql));
            // Executa a query no banco de dados
            this.getPreparedStatement().executeUpdate(sql);
            // Consulta o último código inserido na tabela
            this.setResultSet(this.getPreparedStatement().executeQuery("SELECT last_insert_id();"));
            // Recupera o valor da primeira coluna da tabela
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }
            return status;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        System.out.println(status);
        return status;
    }

    /**
     * Método responsável pela criação do banco de dados e tabelas do mesmo
     * @param connection
     */
    private void configurarBanco(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            // Cria a base de dados
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS teste;");
            // Seleciona base de dados
            stmt.executeUpdate("USE teste;");
            // Cria tabela curso
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS curso ("
                    + "pk_codigo_curso SERIAL NOT NULL PRIMARY KEY,"
                    + "curso_descricao VARCHAR(50) NOT NULL,"
                    + "curso_ementa TEXT"
                    + ");");
            // Cria tabela aluno
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS aluno ("
                    + "pk_codigo_aluno SERIAL NOT NULL PRIMARY KEY,"
                    + "aluno_nome VARCHAR(50) NOT NULL"
                    + ");");
            // Cria tabela que relaciona curso e aluno
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS curso_aluno ("
                    + "pk_codigo SERIAL NOT NULL PRIMARY KEY,"
                    + "fk_aluno BIGINT UNSIGNED,"
                    + "fk_curso BIGINT UNSIGNED,"
                    + "FOREIGN KEY (fk_aluno) REFERENCES aluno(pk_codigo_aluno),"
                    + "FOREIGN KEY (fk_curso) REFERENCES curso(pk_codigo_curso)"
                    + ");");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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

    private PreparedStatement getPreparedStatement() {
        return statement;
    }

    private void setPreparedStatement(PreparedStatement statement) {
        this.statement = statement;
    }

}
