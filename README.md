# Loja
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23336791.svg?style=for-the-badge&logo=postgresql&logoColor=white)

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
ClassDiagram

    class Usuario{
        +Long id;
        +String nome;
        +String email;
        +String senha;
        
        +procurarPorId(Long id)
        +listarUsuarios()
        +cadastrarUsuario(UsuarioRequestDto requestDto)
        +atualizarUsuario(Long id, UsuarioRequestDto requestDto)
        +deletarUsuario(Long id)
    }
    
    class Produto{
        +Long id;
        +String nome;
        +Double preco;
        
        +procurarPorId(Long id)
        +listarProdutos()
        +cadastrarProduto(ProdutoRequestDto requestDto)
        +atualizarProduto(Long id, ProdutoRequestDto requestDto)
        +deletarProduto(Long id)
    }
    
    class Pedido{
        +Long id;
        +Produto produto;
        +Usuario usuario;
        +LocalDateTime dataPedido;
        
        +procurarPorId(Long id)
        +listarPedidos()
        +cadastrarPedido(PedidoRequestDto requestDto)
        +atualizarPedido(Long id, PedidoRequestDto requestDto)
        +deletarPedido(Long id)
    }
    
    Usuario "1" --> "n" Pedido
    Produto "1" --> "n" Pedido
```

## Endpoints

### Usuário
```
GET /usuarios
GET /usuarios/{id}
POST /usuarios
PUT /usuarios/{id}
DELETE /usuarios/{id}
```
### Produto
```
GET /produtos
GET /produtos/{id}
POST /produtos
PUT /produtos/{id}
DELETE /produtos/{id}
```
### Pedido
```
GET /pedidos
GET /pedidos/{id}
POST /pedidos
PUT /pedidos/{id}
DELETE /pedidos/{id}
```