/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class CriarTabela {
    // Este metodo vai criar uma tabela chamada 'usuarios' no nosso banco
    // ele pede um parametro do tipo Connection justamente para saber com que
    // banco estamos trabalhando
   public static void criarTabelaUsuarios(Connection conexao){
       String sql = "CREATE TABLE IF NOT EXISTS usuarios("
               + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
               + "nome VARCHAR(255),"
               + "email VARCHAR(225) NOT NULL UNIQUE)";
       
       // Statement é uma interface da biblioteca JDBC
       // Ele contem um metodo chamado "execute()" que roda nosso CREATE TABLE no banco
       try(Statement stmt = conexao.createStatement() ){
           stmt.execute(sql);
           System.out.println("Tabela criada com sucesso! ");
       }catch(SQLException erro){
           System.out.println("ERRO: " + erro);
       }
   }
}
