package com.api.crudbrasdesco.repositores;

import com.api.crudbrasdesco.models.Curso;
import com.api.crudbrasdesco.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
