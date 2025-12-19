/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoRpg;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class Cena {
    private String caminhoImagem;   // imagem principal
    private String caminhoTexto;    // imagem que contém o texto/narração
    private String escolhaEsq;      // rótulo do botão esquerdo
    private String escolhaDir;      // rótulo do botão direito
    private int proximaCenaEsq;     // índice (ID) da cena destino da esquerda
    private int proximaCenaDir;     // índice (ID) da cena destino da direita

    public Cena(String caminhoImagem, String caminhoTexto,
                String escolhaEsq, String escolhaDir,
                int proximaCenaEsq, int proximaCenaDir) {
        this.caminhoImagem = caminhoImagem;
        this.caminhoTexto = caminhoTexto;
        this.escolhaEsq = escolhaEsq;
        this.escolhaDir = escolhaDir;
        this.proximaCenaEsq = proximaCenaEsq;
        this.proximaCenaDir = proximaCenaDir;
    }

    // Getters (úteis para usar em mostrarCena)
    public String getCaminhoImagem() { return caminhoImagem; }
    public String getCaminhoTexto() { return caminhoTexto; }
    public String getEscolhaEsq() { return escolhaEsq; }
    public String getEscolhaDir() { return escolhaDir; }
    public int getProximaCenaEsq() { return proximaCenaEsq; }
    public int getProximaCenaDir() { return proximaCenaDir; }
}
