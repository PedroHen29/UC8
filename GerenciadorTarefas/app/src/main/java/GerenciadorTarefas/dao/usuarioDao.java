/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.dao;

import GerenciadorTarefas.database.conexao;
import GerenciadorTarefas.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class usuarioDao {
   
    public static boolean salvar(Usuario usuario){
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?,?,?)";
        String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, senhaHash);
            
            stmt.executeUpdate();
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            
            return false;
            
        }
    }
    
    public static boolean deletar(String email){
        String sql = "DELETE FROM usuarios WHERE email = ?";
        
        
       try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, email);           
            stmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean atualizar(Usuario usuario, String novoNome){
        String sql = "UPDATE usuarios SET nome = ? WHERE email = ?";
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, novoNome);
            stmt.setString(2, usuario.getEmail());
            
            stmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static Usuario buscarPorEmail(String email){
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return new Usuario(
                        rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
