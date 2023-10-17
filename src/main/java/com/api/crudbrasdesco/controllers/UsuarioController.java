package com.api.crudbrasdesco.controllers;

import com.api.crudbrasdesco.models.Usuario;
import com.api.crudbrasdesco.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> pesquisarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> pesquisarPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarPorId(id));
    }


    @GetMapping("/validaUser")
    public ResponseEntity<Optional<Usuario>> pesquisarPorEmailESenha(@RequestParam String email,
                                                                     @RequestParam String senha) {
        return ResponseEntity.status(HttpStatus.OK).body(service.pesquisarPorEmailESenha(email, senha));
    }

    @PostMapping()
    public ResponseEntity<Usuario> incluir(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.incluir(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.alterar(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
