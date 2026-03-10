/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorBiblioteca.dao;

import GerenciadorBiblioteca.database.Conexao;
import GerenciadorBiblioteca.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */

// DAO siginifica Data Access Object (Objeto de Acesso a Dados )
// Nesta camada, vão classes que contem metodos para trabalhar com o banco
// por exemplo, inserir, ler, atualizar, deletar informações (CRUD)
public class LivroDAO {
    public static void cadastrar(Livro livro){
        String sql = "INSERT INTO livros (titulo, autor, anoPublicacao, categoria) VALUES (?,?,?,?)";
        
        try(Connection conn = Conexao.getConnection()){
            
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        pstmt.setString(1, livro.getTitulo());
        pstmt.setString(2, livro.getAutor());
        pstmt.setInt(3, livro.getAnoPublicacao());
        pstmt.setString(4, livro.getCategoria());
        
        pstmt.executeUpdate();
            System.out.println("Livro castradato com sucesso! ");
        }catch(Exception erro){
            System.out.println("Erro ao castrar o livro: " + erro.getMessage());
        }
    }
    
    public static ArrayList<Livro> listar(){
        ArrayList<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        
        try(Connection conn = Conexao.getConnection()){
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livro.setCategoria(rs.getString("categoria"));
                livros.add(livro);
            }
            
        }catch(Exception erro){
            System.out.println("Erro ao listar: " + erro.getMessage());
        }
        return livros;
    }
    
    public static void deletarLivro(int id){
        String sql = "DELETE FROM livros WHERE id = ?";
        
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Livro deletado com sucesso! ");
            
        }catch(Exception erro){
            System.out.println("Erro ao deletar: " + erro.getMessage());
        }
    }
    
    public static void atualizarLivro(int id, String titulo, String autor, String categoria){
        String sql = "UPDATE livros SET titulo = ?, autor = ?, categoria = ? WHERE id = ?";
        
        try(Connection conn = Conexao.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setString(3, categoria);
            pstmt.setInt(4, id);
            
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if(linhasAtualizadas > 0){
                System.out.println("Livro atualizado! ");
            }else {
                System.out.println("Livro nao encontrado! ");
            }
            
        }catch(Exception erro){
            System.out.println("Erro ao atualizar livro: " + erro.getMessage());
        }
            
    }
}
    

