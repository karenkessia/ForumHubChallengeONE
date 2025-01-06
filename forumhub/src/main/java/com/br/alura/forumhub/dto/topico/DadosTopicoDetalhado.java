package com.br.alura.forumhub.dto.topico;

import com.br.alura.ForumHub.dto.resposta.DadosRespostaResponse;
import com.br.alura.ForumHub.model.entities.Resposta;
import com.br.alura.ForumHub.model.entities.Topico;
import com.br.alura.ForumHub.model.enums.StatusTopico;

import java.util.List;

public record DadosTopicoDetalhado(
        Long id,
        String titulo,
        String mensagem,
        String nomeAutor,
        StatusTopico status,
        List<DadosRespostaResponse> respostas
) {
    public DadosTopicoDetalhado(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getAutor() == null ? null : topico.getAutor().getNome(),
                topico.getStatus(),
                topico.getRespostas()
        );
    }
}