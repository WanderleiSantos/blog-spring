package br.com.wanderlei.blog.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Wanderlei Santos on 21/06/2017.
 */
@Entity
@Table(name = "comentarios")
public class Comentario  extends AbstractPersistable<Long> implements Comparable<Comentario>{

    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;

    @Column(name = "data_comentario")
    private Date dataComentario;

    @ManyToOne(fetch = FetchType.EAGER)
    private Postagem postagem;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(Date dataComentario) {
        this.dataComentario = dataComentario;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int compareTo(Comentario comentario) {
        return comentario.getDataComentario().compareTo(this.dataComentario);
    }
}
