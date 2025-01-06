package com.br.alura.forumhub.validacao.topico.atualizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.alura.forumhub.infra.exception.ValidacaoException;

@Component
public class ValidacaoDeExistenciaTopico implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findById(id);

        if(topico).isEmpty() {
            throw new ValidacaoException("Informe um ID do topico valido.");
        }
    }
}
