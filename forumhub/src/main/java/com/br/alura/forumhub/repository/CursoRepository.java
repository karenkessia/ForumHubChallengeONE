package com.br.alura.forumhub.repository;

import com.br.alura.ForumHub.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    // procurar por nome ignorando case
    Curso findByNomeIgnoreCase(String nome);
}
