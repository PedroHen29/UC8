/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorBiblioteca.controller;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */

// Classe auxiliar que sera chamada no LivroController
// Se um metodo ocorreu como esperado, sucesso sera true
// Ele tambem retorna uma mensagem, que sera adaptada para cada caso

public class Resultado {
    private boolean sucesso;
    private String mensagem;

    public Resultado(boolean sucesso, String mensagem) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
    }
    
    public boolean isSucesso(){
        return sucesso;
    }
    
    public String getMensagem(){
        return mensagem;
    }
}
