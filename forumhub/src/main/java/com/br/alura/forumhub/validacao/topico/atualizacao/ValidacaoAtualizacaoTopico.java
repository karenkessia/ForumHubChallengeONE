package com.br.alura.forumhub.validacao.topico.atualizacao;

public interface ValidacaoAtualizacaoTopico {
    void validar(Long id, DadosTopicoAtualizacao dados);
}