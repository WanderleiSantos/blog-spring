package br.com.wanderlei.blog.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "postagens_has_categorias",
            joinColumns = @JoinColumn(name = "postagem_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @OneToMany(mappedBy = "postagem", fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Comentario> getComentarios() {
        if (comentarios != null) {
            Collections.sort(comentarios);
        }
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
