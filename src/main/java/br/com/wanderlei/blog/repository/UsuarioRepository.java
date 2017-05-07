package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Avatar;
import br.com.wanderlei.blog.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wanderlei on 07/05/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByAvatar(Avatar avatar);
}
