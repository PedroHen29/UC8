/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.service;

import GerenciadorTarefas.dao.usuarioDao;
import GerenciadorTarefas.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class usuarioService {
    public static boolean registrar(Usuario usuario) {

        if (usuario.getNome().isBlank() || usuario.getEmail().isBlank() || usuario.getSenha().isBlank()) {
            return false;
        }

        return usuarioDao.salvar(usuario);
    }
    
    public static boolean apagar( String senha, String email){
        Usuario usuario = usuarioDao.buscarPorEmail(email);
        
        if(usuario != null){
            if(BCrypt.checkpw(senha, usuario.getSenha())){
                System.out.println("Usuario encontrado! ");
                usuarioDao.deletar(email);
                return true;
            }
        }
        System.out.println("Email ou senha incorretos");
            return false;
        
            
    }
    
     // recebe o email e a senha
    public static boolean login(String email, String senha) {
        // procura o usuario que tem aquele que tem email
        Usuario usuario = usuarioDao.buscarPorEmail(email);
        
        // se encontrar
        if (usuario != null) {
            // ele verifica se a senha bate com a criptografia
            if (BCrypt.checkpw(senha, usuario.getSenha())) {
                // se sim, retorna o usuario
                System.out.println("Usuario encontrado! ");
                return true;
            }
        }
        // se nao, retorna null
        System.out.println("Email ou senha incorretos! ");
        return false;
    }
}
