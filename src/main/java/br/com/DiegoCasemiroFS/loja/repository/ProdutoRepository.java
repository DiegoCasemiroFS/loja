package br.com.DiegoCasemiroFS.loja.repository;

import br.com.DiegoCasemiroFS.loja.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
