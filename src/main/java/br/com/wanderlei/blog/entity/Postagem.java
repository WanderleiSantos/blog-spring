package br.com.wanderlei.blog.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wanderlei on 01/06/17.
 */
@Entity
@Table(name = "postagens")
public class Postagem extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true, length = 60)
    private String titulo;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String texto;

    @Column(nullable = false, unique = true, length = 60)
    private String permalink;

    @Column(name = "data_postagem", nullable = false)
    private Date dataPostagem;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public Date getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(Date dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
