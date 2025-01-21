package br.com.DiegoCasemiroFS.loja.entity.dtos;

import br.com.DiegoCasemiroFS.loja.entity.Endereco;
import br.com.DiegoCasemiroFS.loja.entity.enums.Funcao;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto {

    private String email;

    private String senha;

    private boolean admin;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    @Embedded
    private Endereco endereco;
}
