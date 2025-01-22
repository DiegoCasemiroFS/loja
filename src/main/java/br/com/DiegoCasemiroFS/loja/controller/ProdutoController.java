package br.com.DiegoCasemiroFS.loja.controller;

import br.com.DiegoCasemiroFS.loja.entity.Produto;
import br.com.DiegoCasemiroFS.loja.entity.dtos.ProdutoRequestDto;
import br.com.DiegoCasemiroFS.loja.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/procuraPorId/{id}")
    public Produto procurarPorId(@PathVariable Long id){
        return produtoService.procuraPorId(id);
    }

    @GetMapping("/listaProdutos")
    public List<Produto> listaProdutos(){
        return produtoService.listaProdutos();
    }

    @PostMapping("/cadastraProduto")
    public Produto cadastraProduto(@RequestBody Produto produto){
        return produtoService.cadastraProduto(produto);
    }

    @PutMapping("/atualizaProduto/{id}")
    public Produto atualizaProduto(@PathVariable Long id, @RequestBody ProdutoRequestDto produtoRequestDto){
        return produtoService.atualizaProduto(id, produtoRequestDto);
    }

    @DeleteMapping("/deletaProduto/{id}")
    public void deletaProduto(@PathVariable Long id){
        produtoService.deletaProduto(id);
    }
}
