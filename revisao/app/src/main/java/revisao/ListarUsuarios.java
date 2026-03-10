/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.transform.sax.SAXSource;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class ListarUsuarios {
    public static void ListarUsuarios(Connection conexao){
        String sql = "SELECT * FROM usuarios";
        
        try(Statement stmt = conexao.createStatement()){
            // Um select retorna varios resultados
            // estes resultados sao como uma tabela do excel
            // armazenamos isso em um tipo especifico, chamado ResultSet
            // algo como 'resultado da pesquisa'
            // para executar um select, utilizamos o metodo 'executeQuery()'
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID | NOME | EMAIL");
            while(rs.next()){
                System.out.println(rs.getInt("id") 
                        + "|" + rs.getString("nome") 
                        + "|" + rs.getString("email"));
            }
        }catch(Exception erro){
            System.out.println("Erro ao listar usuarios: " + erro.getMessage());
        }
    }
    
    public static void ListarporEmail(Connection conexao, String email ){
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("ID | NOME | EMAIL");
            while(rs.next()){
                System.out.println(rs.getInt("id") 
                        + " | " + rs.getString("nome")
                        + " | " + rs.getString("email"));
            }
            
        }catch(Exception erro){
            System.out.println("Erro ao listar usuario: " + erro.getMessage());
        }
    }
}
