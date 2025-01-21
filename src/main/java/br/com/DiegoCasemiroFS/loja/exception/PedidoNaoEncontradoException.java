package br.com.DiegoCasemiroFS.loja.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException(){
        super("Pedido não encontrado, informe um Id válido!");
    }
}
