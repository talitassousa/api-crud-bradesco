package com.api.crudbrasdesco.services;

import com.api.crudbrasdesco.models.Curso;
import com.api.crudbrasdesco.repositores.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public List<Curso> pesquisarTodos() {
        return repository.findAll();
    }

    public Optional<Curso> pesquisarPorId(UUID id) {
        return repository.findById(id);
    }

    public Curso incluir(Curso curso) {
        return repository.save(curso);
    }

    public Curso alterar(Curso curso) {

        return repository.save(curso);
    }

    public void excluir(UUID id) {
        repository.deleteById(id);
    }

}
