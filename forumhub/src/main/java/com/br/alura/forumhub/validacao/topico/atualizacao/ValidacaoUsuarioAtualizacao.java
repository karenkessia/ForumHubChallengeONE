package com.br.alura.forumhub.validacao.topico.atualizacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.alura.forumhub.infra.exception.ValidacaoException;
import com.br.alura.forumhub.model.entities.Topico;

@Component
public class ValidacaoUsuarioAtualizacao implements ValidacaoAtualizacaoTopico{

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void validar(Long id, DadosTopicoAtualizacao dados) {
        Topico topico = topicoRepository.findById(id)).orElse(null);

        if(topico.getAutor() != usuarioService.usuarioAtual()) {
            throw new ValidacaoException("Usuario nao autorizado para atualizar o topico.");
        }
    }
}
