package br.com.DiegoCasemiroFS.loja.repository;

import br.com.DiegoCasemiroFS.loja.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
