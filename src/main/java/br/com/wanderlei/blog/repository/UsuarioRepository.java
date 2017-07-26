package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Avatar;
import br.com.wanderlei.blog.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wanderlei on 07/05/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByAvatar(Avatar avatar);

    @Modifying
    @Query("update Usuario u set u.nome = ?1, u.email = ?2 where u.id = ?3")
    void updateNomeAndEmail(String nome, String email, Long id);

    @Modifying
    @Query("update Usuario u set u.senha = ?1 where u.id = ?2")
    void updateSenha(String senha, Long id);

    Page<Usuario> findAllByOrderByNomeAsc(Pageable pageable);
}
