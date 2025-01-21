package br.com.DiegoCasemiroFS.loja.entity.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {

    private Long UsuarioId;
    private Long ProdutoId;
}
