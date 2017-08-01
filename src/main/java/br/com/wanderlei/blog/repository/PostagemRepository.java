package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Postagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wanderlei on 01/06/17.
 */
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Page<Postagem> findAllByOrderByDataPostagemDesc(Pageable pageable);

    Postagem findByPermalink(String permalink);

    List<Postagem> findByCategoriasPermalink(String link);

    List<Postagem> findByAutorNome(String nome);

    Page<Postagem> findAllByCategoriasPermalinkOrderByDataPostagemDesc(Pageable pageable, String permalink);

    Page<Postagem> findAllByAutorIdOrderByDataPostagemDesc(Pageable pageable, Long id);

    Page<Postagem> findByTextoContainingIgnoreCaseOrderByDataPostagemDesc(String texto, Pageable pageable);

    Page<Postagem> findAllByTituloContainingIgnoreCaseOrderByDataPostagemDesc(Pageable pageable, String titulo);
}
