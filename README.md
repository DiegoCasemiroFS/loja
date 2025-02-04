# Loja
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23336791.svg?style=for-the-badge&logo=postgresql&logoColor=white)

## Objetivo

- Desenvolver uma API utilizando Banco de Dados PostgreSQL para o gerenciamento de Usuários, Produtos e Pedidos.

## Sobre o projeto

- Esta API simula um aplicativo para a venda de produtos. Ela foi desenvolvida utilizando o Spring Framework
e oferece funcionalidades para o gerenciamento de Usuários e Pedidos.

## Instruções de Uso

- Para manuseio da API é necessário criar um Usuário.
- Todos os Usuários podem realizar um Pedido.
- Para realizar um Pedido, basta informar o Id do Usuário e do Produto.
- Para atualizar um Pedido, o Id do Usuário não pode ser alterado, somente o Id do Produto.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Lombok
- PostgreSQL

## Download

```bash
git clone https://github.com/DiegoCasemiroFS/loja.git
```

## Documentação 
```bash
http://localhost:8080/v3/api-docs
```
```bash
http://localhost:8080/swagger-ui/index.html
```

## Diagrama de Classes

```mermaid
classDiagram

    class Usuario {
        +Long id
        +String nome
        +String email
        +String senha
        +Endereco endereco
        +Funcao funcao
        +booleam admin

        +procuraPorId(Long id)
        +listaUsuarios()
        +cadastraUsuario(UsuarioRequestDto requestDto)
        +atualizaUsuario(Long id, UsuarioRequestDto requestDto)
        +deletaUsuario(Long id)
    }
    
    class Endereco {
        +Long id
        +String rua
        +String numero
        +String bairro
        +String cidade
        +String estado
        +String cep
    }

    class Produto {
        +Long id
        +String nome
        +TipoProduto tipo
        +Integer quantidade
        +BigDecimal preco

        +procuraPorId(Long id)
        +listaProdutos()
        +cadastraProduto(ProdutoRequestDto requestDto)
        +atualizaProduto(Long id, ProdutoRequestDto requestDto)
        +deletaProduto(Long id)
    }

    class Pedido {
        +Long id
        +Usuario usuario
        +Produto produto
        +LocalDateTime dataPedido

        +procuraPorId(Long id)
        +listaPedidos()
        +cadastraPedido(PedidoRequestDto requestDto)
        +atualizaPedido(Long id, PedidoRequestDto requestDto)
        +deletaPedido(Long id)
    }

    Usuario "1" --> "n" Pedido
    Produto "1" --> "n" Pedido
```