package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wanderlei on 01/06/17.
 */
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Postagem findByPermalink(String permalink);

    List<Postagem> findByCategoriasPermalink(String link);

    List<Postagem> findByAutorNome(String nome);
}
