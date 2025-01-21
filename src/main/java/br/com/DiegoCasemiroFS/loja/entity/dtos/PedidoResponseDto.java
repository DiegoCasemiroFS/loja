package br.com.DiegoCasemiroFS.loja.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private Long id;
    private String nomeUsuario;
    private String nomeProduto;
    private BigDecimal preco;
    private LocalDateTime dataPedido;
}
