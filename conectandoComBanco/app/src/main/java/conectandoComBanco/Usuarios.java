/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conectandoComBanco;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Usuarios {
    private int id;
    private String nome;
    private String email;

    public Usuarios(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    public int getId(){return id;}
    public String getNome(){return nome;}
    public String getEmail(){return email;}
}
