package br.com.DiegoCasemiroFS.loja.entity;

import br.com.DiegoCasemiroFS.loja.entity.enums.Funcao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private boolean admin;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private List<Pedido> pedido = new ArrayList<>();
}
