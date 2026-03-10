/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class ConexaoSQLite {
    // Método para conectar ao banco de dados
    public static Connection conectar(){
        // Variavel que armazena a conexão
        // Inicialmenre é nula
        Connection conectar = null;
        // String qye representa o caminho ate o banco de dados
        // ou seja, serve para saber onde ele está
        String url = "jdbc:sqlite:usuarios.db";
        
        try{
            // O metodo getConnection da classe DriveManager
            // se conecta com o banco que informamos (dentro de url)
            // ele retorna esta conexão
            conectar = DriverManager.getConnection(url);
            System.out.println("Conexão estabelecida com sucesso!");
        }catch(SQLException erro ){ // Caso haja algum erro para se conectar, ele cai nesta parte
            System.out.println("Erro ao tentar se conectar: " + erro.getMessage());
        }
        return conectar;
    }
}
