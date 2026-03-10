/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorBiblioteca.controller;

import GerenciadorBiblioteca.model.Livro;
import GerenciadorBiblioteca.service.LivroService;
import java.util.ArrayList;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */

/*
    O Controller coordeba o fluxo da aplicação.
    Ele:
    - Recebe a ação da View (dados crus)
    - Monta o Model
    - Chama o Service
    - Trata exceções
    - Retorna um algo que vai ser usado na Niew (resultado)
*/
public class LivroController {
    // Crio uma instancia de LivroService
    private LivroService service = new LivroService();
    
    public Resultado cadastrar(String titulo, String autor, int ano, String categoria){
        
        // Controller monta um objeto
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(ano);
        livro.setCategoria(categoria);
        
        try{
            service.cadastrarLivro(livro);
            return new Resultado(true, "Livro cadastrado com sucesso! ");
        }catch(IllegalArgumentException e){
            // Erro de regra de negocio
            return new Resultado(false, e.getMessage());
        }
    }
    
    public Resultado atualizar(int id, String titulo, String autor, int ano, String categoria){
        // Controller monta um objeto
        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(ano);
        livro.setCategoria(categoria);
        
        try{
            service.atualizarLivro(livro, titulo, autor, categoria);
            return new Resultado(true, "Livro atualizado com sucesso! ");
        }catch(IllegalArgumentException e){
            // Erro de regra de negocio
            return new Resultado(false, e.getMessage());
        }
    }
    
   public Resultado deletar(int id){
        try{
            service.deletarLivro(id);
            return new Resultado(true, "Livro removido");
        }catch(IllegalArgumentException e){
            return new Resultado(false, e.getMessage());
        }
    }
   
    public ArrayList<Livro> listarLivros(String titulo, String autor, int ano, String categoria) {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(ano);
        livro.setCategoria(categoria);
        return service.listarLivros();
    }

}
