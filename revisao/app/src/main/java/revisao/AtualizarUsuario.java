/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class AtualizarUsuario {
    public static void atualizarUusario(Connection conexao, int id, String email, String novoEmail, String nome){
        // Atualizar a tabela usuarios definindo um novo nome e um novo email
        // para quem tiver o id 'tal'
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if(linhasAtualizadas > 0){
                System.out.println("Usuario atualizado com sucesso! ");
            }else {
                System.out.println("Usuario não encontrado");
            }
        }catch(SQLException erro){
            System.out.println("Erro ao atualizar usuario: " + erro.getMessage());
        }
    }
}
