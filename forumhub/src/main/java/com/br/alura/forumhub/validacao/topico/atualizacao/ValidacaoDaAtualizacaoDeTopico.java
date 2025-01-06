package com.br.alura.forumhub.validacao.topico.atualizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.alura.forumhub.infra.exception.ValidacaoException;

@Component
public class ValidacaoDaAtualizacaoDeTopico implements ValidacaoAtualizacaoTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        var topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if(topico != null) {
            throw new ValidacaoException("Já existe um tópico com o mesmo título e mensagem");
        }
    }
}
