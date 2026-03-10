/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.controller;

import GerenciadorTarefas.model.Usuario;
import GerenciadorTarefas.service.usuarioService;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class controller {
    public static boolean registrar(String nome, String email, String senha) {
        Usuario novoUsuario = new Usuario(nome, email, senha);
        return usuarioService.registrar(novoUsuario);
    }
    
    public static boolean apagar(String email, String senha){
        return usuarioService.apagar(senha, email);
    }
    
    public static boolean login(String email, String senha) {
        return usuarioService.login(email, senha);
    }
}
