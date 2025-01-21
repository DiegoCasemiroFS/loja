package br.com.DiegoCasemiroFS.loja.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDto {

    private Long id;
    private String nomeUsuario;
    private String nomeProduto;
    private BigDecimal preco;
    private LocalDateTime dataPedido;
}
