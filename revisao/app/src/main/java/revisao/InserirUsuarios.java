/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class InserirUsuarios {
    public static void inserirUsuario(Connection conexao, String nome, String email){
        // Os pontos de interrogação neste query (query significa "consulta")
        // São chamados de 'placeholders', ou 'guarda lugar' em portugues
        // eles tem esse nom pois sao trocados depois
        String sql = "INSERT into usuarios (nome, email) VALUES (?,?)";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
            // Antes de executar, precisamos PREPARAR a nossa query
            // ou seja, precisamos substituir os placeholders ('?') pelos valores corretoszz
            pstmt.setString(1, nome);
            pstmt.setString(2, email);
            
            // Agora que nossa query esta pronta, podemos executa-la
            // usamos executeUpdate() para INSERTS
            pstmt.executeUpdate();
            System.out.println("Usuario inserido com sucesso! ");
        }catch(Exception erro){
            System.out.println("Erro ao inserir usuario: " + erro.getMessage());
        }
    }
}
