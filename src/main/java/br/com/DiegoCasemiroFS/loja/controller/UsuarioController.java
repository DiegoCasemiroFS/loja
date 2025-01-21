package br.com.DiegoCasemiroFS.loja.controller;

import br.com.DiegoCasemiroFS.loja.entity.Usuario;
import br.com.DiegoCasemiroFS.loja.entity.dtos.UsuarioRequestDto;
import br.com.DiegoCasemiroFS.loja.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/procurarPorId/{id}")
    public Usuario procurarPorId(Long id){
        return usuarioService.procuraPorId(id);
    }

    @GetMapping("/procurarPorEmail/{email}")
    public Usuario procurarPorEmail(String email){
        return usuarioService.procuraPorEmail(email);
    }

    @GetMapping("/listaUsuarios")
    public void listaUsuarios(){
        usuarioService.listaUsuarios();
    }

    @PostMapping("/cadastraUsuario")
    public Usuario cadastraUsuario(Usuario usuario){
        return usuarioService.cadastraUsuario(usuario);
    }
    @PutMapping("/atualizaUsuario/{id}")
    public Usuario atualizaUsuario(Long id, UsuarioRequestDto usuarioRequestDto){
        return usuarioService.atualizaUsuario(id, usuarioRequestDto);
    }

    @DeleteMapping("/deletaUsuario/{id}")
    public void deletaUsuario(Long id){
        usuarioService.deletaUsuario(id);
    }
}

