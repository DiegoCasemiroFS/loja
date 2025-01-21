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

    public Usuario procuraPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
    }

    public Usuario procuraPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastraUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizaUsuario(Long id, UsuarioRequestDto usuarioRequestDto) {
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

    public void deletaUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
