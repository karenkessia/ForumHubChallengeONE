package com.br.alura.forumhub.validacao.topico.atualizacao;

import org.springframework.stereotype.Component;

import com.br.alura.forumhub.infra.exception.ValidacaoException;

@Component
public class ValidacaoDeCampo implements ValidacaoAtualizacaoTopico{
    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        if( dados.titulo() == null && dados.mensagem() == null){
            throw new ValidacaoException("É necessário informar ao menos um campo para atualização");
        }
    }
}