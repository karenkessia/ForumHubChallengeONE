package com.br.alura.forumhub.dto.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosRespostaCadastro(
        @NotBlank
        String mensagem,
        @NotBlank
        String solucao
) {
}
