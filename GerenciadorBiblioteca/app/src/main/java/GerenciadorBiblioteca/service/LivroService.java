/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorBiblioteca.service;

import GerenciadorBiblioteca.dao.LivroDAO;
import GerenciadorBiblioteca.model.Livro;
import java.util.ArrayList;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */

/*
    O Service é a camada que aplica as regras do sistema 
    e decide se uma ação pode ou não acontecer. É ele quem chama os métodos
    das classes da camada DAO e valida.
*/
public class LivroService {
    // Aqui ficam as REGRAS DE NEGÓCIO do sistema
    // Não tem SQL, não tem interface gráfica e não acessa banco diretamente


    // Método responsável por cadastrar um livro
    // Antes de salvar, ele valida as regras de negócio
    public void cadastrarLivro(Livro livro) {

        // Regra de negócio:
        // Um livro NÃO pode ser cadastrado sem título
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {

            // Lança uma exceção se a regra for violada
            // O DAO NÃO faz validação, quem valida é o Service
            // IllegalArgumentException é uma exceção padrão do Java usada quando
            // um método recebe um argumento inválido
            // O Service é o guardião das regras.
            // Ao lançar a excessão, interrompemos o método imediatamente, forçamos
            // quem chamou a lidar com o erro e evitamos que o sistema entre em estado inválido
            // Não usamos if/else e System.out.println porque com ele o código continua 
            // “silenciosamente”, e quem chamou o método não sabe que falhou
            throw new IllegalArgumentException("Título é obrigatório");
        }

        // Regra de negócio:
        // Ano de publicação precisa ser válido
        // Essa regra não tem relação com banco, por isso fica no Service
        if (livro.getAnoPublicacao() < 1500) {
            throw new IllegalArgumentException("Ano de publicação inválido");
        }
        // Se todas as regras passaram, o Service manda o DAO salvar no banco
        LivroDAO.cadastrar(livro);
    }

        // Aqui não existe regra de negócio
        // O Service apenas pede para o DAO buscar os dados
    public ArrayList<Livro> listarLivros() {
        return LivroDAO.listar();
    }
    
    
    // Atualizar também precisa validar regras
    public void atualizarLivro(Livro livro,  String titulo, String autor, String categoria) {

        // Regra de negócio:
        // Para atualizar, o livro precisa ter ID
        if (livro.getId() <= 0) {
            throw new IllegalArgumentException("ID do livro inválido");
        }

        // Reaproveitamos regras parecidas com o cadastro
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new IllegalArgumentException("Título é obrigatório");
        }

        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new IllegalArgumentException("Autor é obrigatório");
        }

        if (livro.getAnoPublicacao() < 1500) {
            throw new IllegalArgumentException("Ano de publicação inválido");
        }

        // Se tudo estiver correto,
        // o Service manda o DAO atualizar no banco
        LivroDAO.atualizarLivro(0, titulo, autor, categoria);
    }

    
    // Aqui também existe regra de negócio
    public void deletarLivro( int id) {

        // Regra de negócio:
        // Não faz sentido deletar um livro sem ID válido
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão");
        }

        // Service autoriza o DAO a remover do banco
        LivroDAO.deletarLivro(id);
    }
}
