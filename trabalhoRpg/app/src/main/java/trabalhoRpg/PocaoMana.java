/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoRpg;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class PocaoMana extends Item{
    
    public PocaoMana(String nome, String raridade) {
        super(nome, raridade);
    }
    
    public void habilidade(Personagem personagem){
        int mana = 20;
        personagem.mana = personagem.mana + mana;
    }
    
}
