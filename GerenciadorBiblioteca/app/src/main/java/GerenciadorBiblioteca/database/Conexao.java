/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorBiblioteca.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */

// Na camada databese, vao apenas as configurações, links, usuario, senha e metodos necessarios
// para conectar com o banco
public class Conexao {
    
    // Usamos o 'final' para identificar que uma variavel é CONSTANTE
    // por convenção, estas variaveis tem o nome todo maiusculo
    // não usamos camelCase
    // se tiver mais de uma palavra, usamos o '_' Exemplo: MINHA_SENHA
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    // Este metodo retorna a conexao com o banco
    // No padrao MVC, cada camada tem sua responsabilidade
    // NÃO é responsabilidade da camada 'database' tratar excessoes
    // porem, utilizamos dentro deste metodo um outro que pode lançar uma excessao
    // entao, usamos 'throws SQLException' que passa essa excessao adiante
    // ou seja, quem chamar o metodo 'getConnection' vai tratar ele com try e catch depois
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection( URL, USER, PASSWORD);
    }
}
