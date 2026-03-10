/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.controller;

import GerenciadorTarefas.model.Tarefas;
import GerenciadorTarefas.model.Usuario;
import GerenciadorTarefas.service.tarefasService;
import GerenciadorTarefas.service.usuarioService;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class tarefasController {
    public static boolean registrar(String titulo, String descricao, String concluido) {
        Tarefas novaTarefa = new Tarefas(titulo, descricao, concluido);
        return tarefasService.registrar(novaTarefa);
    }
    
    public static boolean apagar( int id){
        return tarefasService.apagar(id);
    }
}
