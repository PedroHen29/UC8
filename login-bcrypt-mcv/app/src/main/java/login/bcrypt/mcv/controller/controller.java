/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login.bcrypt.mcv.controller;

import login.bcrypt.mcv.model.Usuario;
import login.bcrypt.mcv.service.usuarioService;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class controller {
    

    public static boolean registrar(String email, String senha) {
        Usuario novoUsuario = new Usuario(email, senha);
        return usuarioService.registrar(novoUsuario);
    }

    public static boolean login(String email, String senha) {
        return usuarioService.login(email, senha);
    }
}
