package com.api.strategy;

import com.api.model.Usuario;

import java.util.List;

public interface UsuarioStrategy {

    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario buscarPorId(Long id);
    Usuario atualizar(Long id, Usuario usuario);
    void deletar(Long id);

}
