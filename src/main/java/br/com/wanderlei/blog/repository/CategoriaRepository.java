package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wanderlei on 09/06/17.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByDescricao(String descricao);
    Page<Categoria>  findAllByOrderByIdAsc(Pageable pageable);
    Page<Categoria>  findAllByOrderByDescricaoAsc(Pageable pageable);
}
