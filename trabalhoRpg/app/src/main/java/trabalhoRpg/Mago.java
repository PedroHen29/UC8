/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoRpg;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Mago extends Personagem {
    
    public Mago(String nome, int vida, int mana, int forca, int agilidade) {
        super(nome, vida, mana, forca, agilidade);
    }
    
    public void atacar(Personagem inimigo){
       if(calcularChancedeAcerto(inimigo) == true){
        int dano = this.forca + rolarDados(1,6);
        inimigo.vida = inimigo.vida - dano;
    }else{
           
       }
    }   
    public boolean usarHabilidade(Personagem inimigo){
        if(rolarDados(1,6) >= 4){
        int habilidade = this.forca *2 + rolarDados(1,6);
        inimigo.vida = inimigo.getVida() - habilidade ;
        this.mana = this.mana - 2;
        return true;
        }else {
            return false;
        }
           
        
    }    
    public void usarItem(Item item){
        item.habilidade();
    }
     public boolean fugir(){
        return true;
    }
    
    public int rolarDados(int quantidade, int lados){
    int resultado = 0;
    for(int i = 0; i < quantidade; i++){
        resultado += (int)(Math.random() * lados) + 1;
    }
    return resultado;
}
    
     public boolean calcularChancedeAcerto(Personagem inimigo){
        int chance = 50 + (this.agilidade - inimigo.agilidade) * 5;
        int numero = (int) (Math.random()*100);
        if(numero >= chance){
            return true;
        }else{
            return false;
        }
    }    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }
}
