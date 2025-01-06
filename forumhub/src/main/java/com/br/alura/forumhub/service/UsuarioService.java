package com.br.alura.forumhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.alura.forumhub.dto.usuario.DadosCadastroUsuario;
import com.br.alura.forumhub.dto.usuario.DadosUsuarioAtualizacao;
import com.br.alura.forumhub.dto.usuario.DadosUsuarioResponse;
import com.br.alura.forumhub.infra.exception.ValidacaoException;
import com.br.alura.forumhub.model.entities.Topico;
import com.br.alura.forumhub.model.entities.Usuario;
import com.br.alura.forumhub.repository.TopicoRepository;
import com.br.alura.forumhub.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario usuarioAtual() {
        var email = (String) SecurityContextHolder.getContext().getAuthentication().getName();
        return (Usuario) usuarioRepository.findByEmail(email);
    }

    /**
     * @param cadastro
     * @return
     */
    @Transactional
    public DadosUsuarioResponse cadastrarUsuario(DadosCadastroUsuario cadastro) {

        if (usuarioRepository.findByEmail(cadastro.email()) != null) {
            throw new ValidacaoException("Email já cadastrado");
        }

        Usuario usuario = new Usuario(cadastro.nome(), cadastro.email(), criptografarSenha(cadastro.senha()));

        Usuario novoUsuario = usuarioRepository.save(usuario);

        return new DadosUsuarioResponse(novoUsuario);

    }

    @Transactional
    public DadosUsuarioResponse atualizarUsuario(DadosUsuarioAtualizacao dados) {

        verificarSeUsuarioEstaAtivo();

        Usuario usuario = usuarioAtual();

        if (dados.senha() != null) {
            dados = dados.atualizarSenha(criptografarSenha(dados.senha()));
        }

        usuario.atualizar(dados);

        //Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return new DadosUsuarioResponse(usuario);
    }

    public void verificarSeUsuarioEstaAtivo() {
        Usuario usuario = usuarioAtual();
        if (!usuario.getAtivo()) {
            throw new ValidacaoException("OPERAÇÃO NÃO PERMITIDA: Usuário inativo");
        }
    }

    @Transactional
    public void deletar() {

        verificarSeUsuarioEstaAtivo();
        Usuario usuario = usuarioAtual();
        usuario.deletar();
    }

    public String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }

    public Page<Usuario> buscarUsuario(Pageable paginacao) {
        return usuarioRepository.findByAtivoTrue(paginacao);
    }

    public Page<Topico> buscarTopicos(Pageable paginacao) {
        return topicoRepository.findByAutorId(usuarioAtual().getId(), paginacao);
    }
}