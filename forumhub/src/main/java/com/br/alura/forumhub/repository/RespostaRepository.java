package com.br.alura.forumhub.repository;

import com.br.alura.ForumHub.model.entities.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}