
package main;

import conexao.ConexaoMySql;

/**
 *
 * @author Diego Barbosa
 */
public class programa {
    
    public static void main(String[] args) {
        
        ConexaoMySql teste = new ConexaoMySql();
        
        teste.conectar();
        
        
    }
}
