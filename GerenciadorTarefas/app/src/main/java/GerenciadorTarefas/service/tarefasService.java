/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GerenciadorTarefas.service;

import GerenciadorTarefas.dao.tarefasDao;
import GerenciadorTarefas.dao.usuarioDao;
import GerenciadorTarefas.model.Tarefas;
import GerenciadorTarefas.model.Usuario;

/**
 *
 * @author PEDROHENRIQUEEICHAMA
 */
public class tarefasService {
    public static boolean registrar(Tarefas tarefas) {

        if (tarefas.getTitulo().isBlank() || tarefas.getDescricao().isBlank()) {
            return false;
        }

        return tarefasDao.adicionarTarefas(tarefas);
    }
    
    public static boolean apagar( int id){
        
      if(id <= 0){
          return false;
      }
      tarefasDao.deletarTarefa(id);
      return true;
        
    }
}
