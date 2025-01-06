package com.br.alura.forumhub.validacao.topico.atualizacao.criacao;

import com.br.alura.ForumHub.dto.topico.DadosTopicoCadastro;
import com.br.alura.ForumHub.infra.exception.ValidacaoException;
import com.br.alura.ForumHub.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDoCurso implements ValidacaoCriacaodeTopico {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {
        var curso = cursoRepository.findByNomeIgnoreCase(dados.nomeCurso());
        if (curso == null) {
            throw new ValidacaoException("Curso não encontrado: " + dados.nomeCurso());
        }

    }
}