package br.com.DiegoCasemiroFS.loja.controller;

import br.com.DiegoCasemiroFS.loja.entity.Pedido;
import br.com.DiegoCasemiroFS.loja.entity.dtos.PedidoRequestDto;
import br.com.DiegoCasemiroFS.loja.entity.dtos.PedidoResponseDto;
import br.com.DiegoCasemiroFS.loja.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/procurarPorId/{id}")
    public Pedido procurarPorId(Long id){
        return pedidoService.procuraPorId(id);
    }

    @GetMapping("/listarPedidos")
    public List<Pedido> listarPedidos(){
        return pedidoService.listaPedidos();
    }

    @PostMapping("/cadastrarPedido")
    public PedidoResponseDto cadastrarPedido(PedidoRequestDto pedidoRequestDto){
        return pedidoService.cadastraPedido(pedidoRequestDto);
    }

    @PutMapping("/atualizarPedido/{id}")
    public PedidoResponseDto atualizarPedido(Long id, PedidoRequestDto pedidoRequestDto){
        return pedidoService.atualizaPedido(id, pedidoRequestDto);
    }

    @DeleteMapping("/deletarPedido/{id}")
    public void deletaPedido(Long id){
        pedidoService.deletaPedido(id);
    }
}
