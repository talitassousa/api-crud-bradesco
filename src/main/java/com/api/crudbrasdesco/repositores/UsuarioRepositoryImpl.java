package com.api.crudbrasdesco.repositores;

import com.api.crudbrasdesco.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRepositoryImpl {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> pesquisarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> pesquisarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> pesquisarPorEmailESenha(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }

    public Optional<Usuario> pesquisarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario incluir(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario alterar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
