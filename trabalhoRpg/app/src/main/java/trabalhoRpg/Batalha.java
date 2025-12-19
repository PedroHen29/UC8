/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoRpg;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Batalha {

    private Personagem jogador;
    private Personagem inimigo;

    public Batalha(Personagem jogador, Personagem inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }
    public Personagem getJogador() { return jogador; }
    public Personagem getInimigo() { return inimigo; }
    
    
}
