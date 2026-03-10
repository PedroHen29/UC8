/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectandoComBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class ListarUsuarios {
    public static ArrayList listarClientes(Connection conexao){
        ArrayList<Usuarios> lista = new ArrayList<>() ;
        String sql = "SELECT * FROM usuarios";
        
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
                Usuarios usuario = new Usuarios(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email")
                );
                lista.add(usuario);
                
            }
        }catch(Exception e){
            System.out.println("Erro ao listar usuarios: " + e.getMessage());
        }
        return lista;
    }
}
