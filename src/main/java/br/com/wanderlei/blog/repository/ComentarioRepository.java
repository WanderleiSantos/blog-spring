package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Wanderlei Santos on 21/06/2017.
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
