/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Banco {
    
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    public static void adicionarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    
    public static ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public static Usuario autenticar(String email, char[] senha){
        for(Usuario user : usuarios){
            if(user.getEmail().equals(email) && Arrays.equals(user.getSenha(), senha)){
                return user; // Usuario encontrado
            }
        }
        return null; // Usuario não encontrado
    }
    
    public static boolean atualizarUsuario(String emailAntigo, String novoNome, String novoEmail, char[] novaSenha){
        for(Usuario user : usuarios){
            if(user.getEmail().equals(emailAntigo)){
                user.setNome(novoNome);
                user.setEmail(novoEmail);
                user.setSenha(novaSenha);
                
                return true; // Atualização bem-sucedida
            }
        }
        return false; // Usuario não atualizado
            
    }
    
    public static boolean deletarUsuario(String email){
        for(Usuario user : usuarios){
            if(user.getEmail().equals(email)){
                usuarios.remove(user);
                return true; // Usuario removido
            }
        }
        return false; // Usuario não removido
    }
        
}
