package br.com.wanderlei.blog.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

/**
 * Created by wanderlei on 18/05/17.
 */
@Entity
@Table(name = "autores")
public class Autor extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    @Column(nullable = false, length = 255)
    private String biografia;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
