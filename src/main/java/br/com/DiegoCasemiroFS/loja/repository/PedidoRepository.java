package br.com.DiegoCasemiroFS.loja.repository;

import br.com.DiegoCasemiroFS.loja.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
