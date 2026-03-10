/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectandoComBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class InserirUsuario {
    public static void inserUsuario(Connection conexao, String nome, String email){
    // Consulta para inserir dados ao usuario
    String sql = "INSERT INTO usuarios (nome, email) VALUES (?,?)";
    // try = tente
    // PreparedStatement precisa ser PREPARADO antes de ser EXECUTADO
    // Usamos '?' para representar valores que serão trocados
    // Depois de usar setString(); podemos então exexutar o comando
    // Atraves de executeUpdate()
    try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
        pstmt.setString(1, nome); // Substitui o primeiro ? por 'nome'
        pstmt.setString(2, email); // Substitui o segundo ? por 'email'
        pstmt.executeUpdate();
        System.out.println("Usuario inserido com sucesso!");
    }catch(Exception e){
        System.out.println("Erro ao inserir usuario: " + e.getMessage());
    }
    }
}
