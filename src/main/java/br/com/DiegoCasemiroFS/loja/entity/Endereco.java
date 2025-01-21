package br.com.DiegoCasemiroFS.loja.entity;

import jakarta.persistence.*;

@Embeddable
public class Endereco {

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
