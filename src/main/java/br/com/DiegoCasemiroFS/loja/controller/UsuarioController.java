package br.com.DiegoCasemiroFS.loja.controller;

import br.com.DiegoCasemiroFS.loja.entity.Usuario;
import br.com.DiegoCasemiroFS.loja.entity.dtos.UsuarioRequestDto;
import br.com.DiegoCasemiroFS.loja.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/procurarPorId/{id}")
    public Usuario procurarPorId(@PathVariable Long id){
        return usuarioService.procuraPorId(id);
    }

    @GetMapping("/procurarPorEmail/{email}")
    public Usuario procurarPorEmail(@RequestBody String email){
        return usuarioService.procuraPorEmail(email);
    }

    @GetMapping("/listaUsuarios")
    public List<Usuario> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }

    @PostMapping("/cadastraUsuario")
    public Usuario cadastraUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastraUsuario(usuario);
    }
    @PutMapping("/atualizaUsuario/{id}")
    public Usuario atualizaUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDto usuarioRequestDto){
        return usuarioService.atualizaUsuario(id, usuarioRequestDto);
    }

    @DeleteMapping("/deletaUsuario/{id}")
    public void deletaUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
    }
}

