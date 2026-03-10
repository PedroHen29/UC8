/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.dao;

import GerenciadorTarefas.database.conexao;
import GerenciadorTarefas.model.Tarefas;
import GerenciadorTarefas.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class tarefasDao {
    public static boolean adicionarTarefas(Tarefas tarefas){
        String sql = "INSERT INTO tarefas (titulo, descricao, concluido, id_usuarios) VALUES (?,?,?,?)";
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, tarefas.getTitulo());
            stmt.setString(2, tarefas.getDescricao());
            stmt.setString(3, tarefas.getConcluido());
            stmt.setInt(4, tarefas.getId_usuario());
            
            stmt.executeUpdate();
            return true;
        }catch(Exception e){
            System.out.println("Erro ao adicionar a terfa: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean concluirTarefa(String concluir){
        String sql = "INSERT INTO tarefas (concluido) VALUES (?)";
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, concluir);
            
            stmt.executeUpdate();
            return true;
        }catch(Exception e ){
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarTarefas( String novoTitulo, String novaDescricao, int id){
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ? WHERE id = ?";
        
        try(Connection conn = conexao.conectar()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, novoTitulo);
            stmt.setString(2, novaDescricao);
            stmt.setInt(3, id);
            
            stmt.executeUpdate();
            return true;
        }catch(Exception e ){
            System.out.println("Erro ao atualizar tarefa! " + e.getMessage());
            return false;
        }
    }
    
    public static boolean deletarTarefa( int id){
        String sql = "DELETE FROM tarefas WHERE id = ?";
        
        try(Connection conn = conexao.conectar()){
           PreparedStatement stmt = conn.prepareStatement(sql);
           
           stmt.setInt(1, id);
           stmt.executeUpdate();
           return true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
    
    // 1. Mude o retorno para List
public static List<Tarefas> buscarTarefa(int idUsuario) {
    String sql = "SELECT * FROM tarefas WHERE id_usuarios = ?";
    List<Tarefas> lista = new ArrayList<>(); // 2. Crie a lista

    try (Connection conn = conexao.conectar()) {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        // 3. Use WHILE para pegar todas as tarefas, não só a primeira
            while (rs.next()) {
             Tarefas t = new Tarefas(
                 rs.getInt("id"),
                 rs.getInt("id_usuarios"),
                 rs.getString("titulo"),
                 rs.getString("descricao"),
                 rs.getString("concluido")
             );

             lista.add(t);
         }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista; // 5. Retorna a lista (mesmo que esteja vazia)
}
    
    
}
