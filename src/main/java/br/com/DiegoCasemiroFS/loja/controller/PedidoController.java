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

    @GetMapping("/procuraPorId/{id}")
    public Pedido procurarPorId(@PathVariable Long id){
        return pedidoService.procuraPorId(id);
    }

    @GetMapping("/listaPedidos")
    public List<Pedido> listarPedidos(){
        return pedidoService.listaPedidos();
    }

    @PostMapping("/cadastraPedido")
    public PedidoResponseDto cadastrarPedido(@RequestBody PedidoRequestDto pedidoRequestDto){
        return pedidoService.cadastraPedido(pedidoRequestDto);
    }

    @PutMapping("/atualizaPedido/{id}")
    public PedidoResponseDto atualizarPedido(@PathVariable Long id, @RequestBody PedidoRequestDto pedidoRequestDto){
        return pedidoService.atualizaPedido(id, pedidoRequestDto);
    }

    @DeleteMapping("/deletaPedido/{id}")
    public void deletaPedido(@PathVariable Long id){
        pedidoService.deletaPedido(id);
    }
}
