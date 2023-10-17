package com.api.crudbrasdesco.controllers;

import com.api.crudbrasdesco.models.Curso;
import com.api.crudbrasdesco.models.Usuario;
import com.api.crudbrasdesco.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> pesquisarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> pesquisarPorId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarPorId(id));
    }
    @PostMapping()
    public ResponseEntity<Curso> incluir(@Valid @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.incluir(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> alterar(@PathVariable UUID id, @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.alterar(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

