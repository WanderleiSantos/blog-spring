package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wanderlei on 18/05/17.
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNome(String nome);

    @Modifying
    @Query("update Autor a set a.nome = ?1, a.biografia = ?2 where a.id = ?3")
    void updateNameAndBiografia(String nome, String biografia, Long id);
}
