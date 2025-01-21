package br.com.DiegoCasemiroFS.loja.entity;

import br.com.DiegoCasemiroFS.loja.entity.enums.TipoProduto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    private BigDecimal preco;

    @OneToMany(mappedBy = "produto")
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private List<Pedido> pedido = new ArrayList<>();
}
