package com.api.impl;

import com.api.model.Usuario;
import com.api.repository.UsuarioRepository;
import com.api.strategy.UsuarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioStrategyImpl implements UsuarioStrategy {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario existente = usuarioRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNome(usuario.getNome());
            existente.setIdade(usuario.getIdade());
            existente.setSexo(usuario.getSexo());
            existente.setTelefone(usuario.getTelefone());
            existente.setRua(usuario.getRua());
            existente.setBairro(usuario.getBairro());
            existente.setCidade(usuario.getCidade());
            existente.setEstado(usuario.getEstado());
            existente.setPais(usuario.getPais());
            return usuarioRepository.save(existente);
        }
        return null;
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
