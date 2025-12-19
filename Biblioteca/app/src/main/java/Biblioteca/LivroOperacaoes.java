/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import static Biblioteca.ConexaoSQLite.conectar;
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
public class LivroOperacaoes {
    
    public static void CriarTabela(Connection conexao){       
        String sql = "CREATE TABLE IF NOT EXISTS livros ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "titulo TEXT NOT NULL UNIQUE, "
                    + "autor TEXT NOT NULL )";   
        // Statement é o comando/instruções/consulta que queremos fazer
        // é uma INTERFACE que contem metodos que nos permitem EXECUTAR comandos SQL/ SQLite
        try(Statement stmt = conexao.createStatement()){
            stmt.execute(sql);
            System.out.println("Tabela 'livros' criada ou já existente. ");
        }catch(Exception e ){
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
    
    public static void cadastrarLivro(Connection conexao, String titulo, String autor){
        // Consulta para inserir dados ao usuario
    String sql = "INSERT INTO livros (titulo, autor) VALUES (?,?)";
    // try = tente
    // PreparedStatement precisa ser PREPARADO antes de ser EXECUTADO
    // Usamos '?' para representar valores que serão trocados
    // Depois de usar setString(); podemos então exexutar o comando
    // Atraves de executeUpdate()
    try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
        pstmt.setString(1, titulo); // Substitui o primeiro ? por 'nome'
        pstmt.setString(2, autor); // Substitui o segundo ? por 'email'
        pstmt.executeUpdate();
        System.out.println("Livro inserido com sucesso!");
    }catch(Exception e){
        System.out.println("Erro ao inserir Livro: " + e.getMessage());
    }
    }
    
   public static ArrayList listarLivros(Connection conexao){
        ArrayList<Livros> lista = new ArrayList<>() ;
        String sql = "SELECT * FROM livros";
        
        try(Statement stmt = conexao.createStatement();
                // Usamos executeQuery para executar um 'SELECT'
                // o resultado deste SELECT deve ser armazenado dentro de um ResultSet
                ResultSet rs = stmt.executeQuery(sql)){
            // O ResultSet possui o metodo next(), que retorna true
            // caso haja ma PROXIMA LINHA na consulta
            // ou seja, enquanto houver uma proxima linha, ele le ela
            while(rs.next()){
                // getInt e getString servem para retornar os valores em cada coluna
                // dos resultados da minha consulta
                Livros usuario = new Livros(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("autor")
                );
                lista.add(usuario);
                
            }
        }catch(Exception e){
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
        return lista;
    }
   
   public static void removerLivro(Connection conexao, String titulo){
        String sql = "DELETE FROM livros WHERE titulo = ?";
        try(PreparedStatement pstmt = conexao.prepareStatement(sql)){
            pstmt.setString(1, titulo);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
   
   public static void autualizarLivro(Connection conexao, String titulo, String novoTitulo){
        String sql = "UPDATE livros SET titulo = ? WHERE titulo = ?";
        
        try(PreparedStatement pstmt = conexao.prepareStatement(sql) ){
            pstmt.setString(1, novoTitulo);
            pstmt.setString(2, titulo);
            int linhasAtualizadas = pstmt.executeUpdate();
            
            if(linhasAtualizadas == 0){
                System.out.println("Livro não encontrado");
            }else {
                System.out.println("Livro atualizado com sucesso");
            }
        }catch(SQLException e){
            System.out.println("ERRO: " + e.getMessage());
        }
    }
   
   public static ArrayList listarTitulo(Connection conexao, String titulo){
      ArrayList<Livros> lista = new ArrayList<>();
    String sql = "SELECT * FROM livros WHERE titulo = ?";

    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

        // Define o valor do ?
        stmt.setString(1, titulo);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Livros livro = new Livros(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("autor")
            );
            lista.add(livro);
        }

    } catch (Exception e) {
        System.out.println("Erro ao listar livros: " + e.getMessage());
    }

    return lista;
   }
}


