/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/gerenciadortarefas";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    public static Connection conectar(){
        try {
           return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
}
}
