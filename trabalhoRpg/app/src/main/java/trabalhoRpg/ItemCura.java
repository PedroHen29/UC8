/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoRpg;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class ItemCura extends Item {
    
    public ItemCura(String nome, String raridade) {
        super(nome, raridade);
    }
    
    public void habilidade(Personagem personagem){
        int cura = 20;
        personagem.vida = personagem.vida + cura;
    }
}
