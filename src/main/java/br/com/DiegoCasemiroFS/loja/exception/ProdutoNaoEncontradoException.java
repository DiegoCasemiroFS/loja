package br.com.DiegoCasemiroFS.loja.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado");
    }
}
