
package PrimeiroProjeto;


public class Pessoa {
    String nome = "Pedro";
    int idade = 15;
    double peso = 60.00;
    char inicial = 'P';
    
    
    public void apresentar(){
        System.out.println("Nome: " + nome + 
                "\nIdade: " + idade + 
                "\nPeso: " + peso + 
                "\nInicial: " + inicial);
        // Array em java tem tamanho fixo
        
        
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getInicial() {
        return inicial;
    }

    public void setInicial(char inicial) {
        this.inicial = inicial;
    }
    
    
}
