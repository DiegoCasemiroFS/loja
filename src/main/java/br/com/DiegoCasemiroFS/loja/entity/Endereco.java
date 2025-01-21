package br.com.DiegoCasemiroFS.loja.entity;

import jakarta.persistence.*;

@Entity
@Embeddable
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
}
