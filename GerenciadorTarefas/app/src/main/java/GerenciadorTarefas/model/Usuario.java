/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.model;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Usuario {
    int id;
    String nome;
    String senha;
    String email;

    public Usuario(int id, String nome, String emial, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public Usuario(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
