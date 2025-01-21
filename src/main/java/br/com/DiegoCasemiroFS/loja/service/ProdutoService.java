package br.com.DiegoCasemiroFS.loja.service;

import br.com.DiegoCasemiroFS.loja.entity.Produto;
import br.com.DiegoCasemiroFS.loja.entity.dtos.ProdutoRequestDto;
import br.com.DiegoCasemiroFS.loja.exception.ProdutoNaoEncontradoException;
import br.com.DiegoCasemiroFS.loja.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;


    public Produto procuraPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
    }
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    public Produto cadastraProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizaProduto(Long id, ProdutoRequestDto produtoRequestDto){
        Produto produtoAtualizado = produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
        if(produtoAtualizado != null){
            produtoAtualizado.setNome(produtoRequestDto.getNome());
            produtoAtualizado.setQuantidade(produtoRequestDto.getQuantidade());
            produtoAtualizado.setPreco(produtoRequestDto.getPreco());
            return produtoRepository.save(produtoAtualizado);
        }
        return null;
    }

    public void deletaProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
