/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectandoComBanco;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class CriarTabela {
    public static void criarTabelaUsuarios(Connection conexao){
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "nome TEXT NOT NULL, "
                    + "email TEXT NOT NULL UNIQUE)";   
        // Statement é o comando/instruções/consulta que queremos fazer
        // é uma INTERFACE que contem metodos que nos permitem EXECUTAR comandos SQL/ SQLite
        try(Statement stmt = conexao.createStatement()){
            stmt.execute(sql);
            System.out.println("Tabela 'clientes' criada ou já existente. ");
        }catch(Exception e ){
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
