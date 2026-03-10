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
public class DeletarUsuario {
    public static void deletarUsuario(Connection conexao, String email){
        String sql = "DELETE FROM usuarios WHERE email = ?";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
            System.out.println("Sucesso ao deletar usuario! ");
            
        }catch(SQLException erro){
            System.out.println("Erro ao deletar usuario: " + erro.getMessage());
        }
}
}
