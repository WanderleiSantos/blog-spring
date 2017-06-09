package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wanderlei on 09/06/17.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByDescricao(String descricao);

}
