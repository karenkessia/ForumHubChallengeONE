package com.br.alura.forumhub.dto.usuario;

public record DadosUsuarioAtualizacao(
        String nome,
        String senha
) {
    public DadosUsuarioAtualizacao atualizarSenha(String s) {
        return new DadosUsuarioAtualizacao(this.nome, s);
    }
}
