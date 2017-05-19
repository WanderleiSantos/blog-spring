package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wanderlei on 18/05/17.
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(String nome);
}
