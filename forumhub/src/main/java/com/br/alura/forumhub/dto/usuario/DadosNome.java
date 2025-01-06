package com.br.alura.forumhub.dto.usuario;

import com.br.alura.ForumHub.model.entities.Usuario;

public record DadosNome(String nome) {

    public DadosNome(Usuario usuario) {
        this(usuario.getNome());
    }
}