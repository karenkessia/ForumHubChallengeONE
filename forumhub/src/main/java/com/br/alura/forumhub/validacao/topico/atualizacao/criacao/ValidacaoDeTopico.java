package com.br.alura.forumhub.validacao.topico.atualizacao.criacao;

import com.br.alura.ForumHub.dto.topico.DadosTopicoCadastro;
import com.br.alura.ForumHub.infra.exception.ValidacaoException;
import com.br.alura.ForumHub.model.entities.Topico;
import com.br.alura.ForumHub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDeTopico implements ValidacaoCriacaodeTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validar(DadosTopicoCadastro dados) {

        Topico topico = topicoRepository.findByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if (topico != null) {
            throw new ValidacaoException("Tópico já existente: " + dados.titulo());
        }

    }
}
