package br.com.DiegoCasemiroFS.loja.service;

import br.com.DiegoCasemiroFS.loja.entity.Usuario;
import br.com.DiegoCasemiroFS.loja.entity.dtos.UsuarioRequestDto;
import br.com.DiegoCasemiroFS.loja.exception.UsuarioNaoEncontradoException;
import br.com.DiegoCasemiroFS.loja.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizaCadastro(Long id, UsuarioRequestDto usuarioRequestDto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
        if (usuario != null) {
            usuario.setEmail(usuarioRequestDto.getEmail());
            usuario.setSenha(usuarioRequestDto.getSenha());
            usuario.setAdmin(usuarioRequestDto.isAdmin());
            usuario.setFuncao(usuarioRequestDto.getFuncao());
            usuario.setEndereco(usuarioRequestDto.getEndereco());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
