/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectandoComBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class AtualizarUsuario {
    public static void autualizarUsuario(Connection conexao, String email,  String novoNome, String novoEmail){
        String sql = "UPDATE usuarios SET nome = ?,email = ? WHERE email = ?";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql) ){
            pstmt.setString(1, novoNome);
            pstmt.setString(2, novoEmail);
            pstmt.setString(3, email);
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if(linhasAtualizadas == 0){
                System.out.println("Usuario não encontrado");
            }else {
                System.out.println("Usuario atualizado com sucesso");
            }
        }catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
}
