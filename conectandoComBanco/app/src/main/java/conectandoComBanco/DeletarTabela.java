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
public class DeletarTabela {
    public static void deletarUsuario(Connection conexao){
        String sql = "DROP TABLE usuarios";
        try(Statement stmt = conexao.createStatement()){
            stmt.execute(sql);
            System.out.println("Tabela 'clientes' criada ou já existente. ");
        }catch(Exception e ){
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}
