package com.br.alura.forumhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alura.forumhub.model.entities.Curso;
import com.br.alura.forumhub.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso buscarPorNome(String nome) {
        return cursoRepository.findByNomeIgnoreCase(nome);
    }
}
