package br.com.DiegoCasemiroFS.loja.service;

import br.com.DiegoCasemiroFS.loja.entity.Pedido;
import br.com.DiegoCasemiroFS.loja.entity.Produto;
import br.com.DiegoCasemiroFS.loja.entity.Usuario;
import br.com.DiegoCasemiroFS.loja.entity.dtos.PedidoRequestDto;
import br.com.DiegoCasemiroFS.loja.entity.dtos.PedidoResponseDto;
import br.com.DiegoCasemiroFS.loja.exception.PedidoNaoEncontradoException;
import br.com.DiegoCasemiroFS.loja.exception.ProdutoNaoEncontradoException;
import br.com.DiegoCasemiroFS.loja.exception.UsuarioNaoEncontradoException;
import br.com.DiegoCasemiroFS.loja.repository.PedidoRepository;
import br.com.DiegoCasemiroFS.loja.repository.ProdutoRepository;
import br.com.DiegoCasemiroFS.loja.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProdutoRepository produtoRepository;

    public Pedido procuraPorId(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> listaPedidos(){
        return pedidoRepository.findAll();
    }

    public PedidoResponseDto cadastraPedido(PedidoRequestDto pedidoRequestDto){
        Usuario usuario = usuarioRepository.findById(pedidoRequestDto.getUsuarioId()).orElseThrow(UsuarioNaoEncontradoException::new);
        Produto produto = produtoRepository.findById(pedidoRequestDto.getProdutoId()).orElseThrow(ProdutoNaoEncontradoException::new);

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setProduto(produto);
        pedido.setDataPedido(LocalDateTime.now());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();
        pedidoResponseDto.setId(pedidoSalvo.getId());
        pedidoResponseDto.setNomeUsuario(pedidoSalvo.getUsuario().getNome());
        pedidoResponseDto.setNomeProduto(pedidoSalvo.getProduto().getNome());
        pedidoResponseDto.setPreco(pedidoSalvo.getProduto().getPreco());
        pedidoResponseDto.setDataPedido(pedidoSalvo.getDataPedido());

        return pedidoResponseDto;
    }

    public PedidoResponseDto atualizaPedido(Long id, PedidoRequestDto pedidoRequestDto){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(PedidoNaoEncontradoException::new);
        Usuario usuario = usuarioRepository.findById(pedidoRequestDto.getUsuarioId()).orElseThrow(UsuarioNaoEncontradoException::new);
        Produto produto = produtoRepository.findById(pedidoRequestDto.getProdutoId()).orElseThrow(ProdutoNaoEncontradoException::new);

        if(pedidoRequestDto.getUsuarioId().equals(pedido.getUsuario().getId())){

            pedido.setUsuario(usuario);
            pedido.setProduto(produto);
            pedido.setDataPedido(LocalDateTime.now());

            Pedido novoPedido = pedidoRepository.save(pedido);

            PedidoResponseDto pedidoAtualizado = new PedidoResponseDto();
            pedidoAtualizado.setId(novoPedido.getId());
            pedidoAtualizado.setNomeUsuario(novoPedido.getUsuario().getNome());
            pedidoAtualizado.setNomeProduto(novoPedido.getProduto().getNome());
            pedidoAtualizado.setPreco(novoPedido.getProduto().getPreco());
            pedidoAtualizado.setDataPedido(novoPedido.getDataPedido());

            return pedidoAtualizado;
        }
        throw new PedidoNaoEncontradoException();
    }

    public void deletaPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
