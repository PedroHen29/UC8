/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.model;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Tarefas {
    int id;
    int id_usuario;
    String titulo;
    String descricao;
    String concluido;

    public Tarefas(int id, int id_usuario, String titulo, String descricao, String concluido) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
    }

    public Tarefas(int id_usuario, String titulo, String descricao, String concluido) {
        this.id_usuario = id_usuario;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
    }
    
      public Tarefas( String titulo, String descricao, String concluido) {        
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluido = concluido;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConcluido() {
        return concluido;
    }

    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }

    

    
   
    
    
}
