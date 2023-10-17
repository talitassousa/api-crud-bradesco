package com.api.crudbrasdesco.services;

import com.api.crudbrasdesco.models.Usuario;
import com.api.crudbrasdesco.repositores.UsuarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositoryImpl repository;

    public List<Usuario> pesquisarTodos() {
        return repository.pesquisarTodos();
    }

    public Optional<Usuario> pesquisarPorId(Long id) {
        return repository.pesquisarPorId(id);
    }

    public Optional<Usuario> pesquisarPorEmailESenha(String email, String senha) {
        return repository.pesquisarPorEmailESenha(email, senha);
    }

    public Usuario incluir(Usuario usuario) {
        if (repository.pesquisarPorEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return repository.incluir(usuario);
    }

    public Usuario alterar(Usuario usuario) {
        return repository.alterar(usuario);
    }

    public void excluir(Long id) {
        repository.excluir(id);
    }

}
