package com.br.alura.forumhub.dto.usuario;

import com.br.alura.ForumHub.model.entities.Usuario;

public record DadosUsuarioResponse(
        Long id,
        String nome,
        String email
) {
    public DadosUsuarioResponse(Usuario novoUsuario) {
        this(novoUsuario.getId(), novoUsuario.getNome(), novoUsuario.getEmail());
    }
}