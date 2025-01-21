package br.com.DiegoCasemiroFS.loja.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDto {

    private String nome;

    private BigDecimal preco;
}
