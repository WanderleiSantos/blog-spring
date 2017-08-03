package br.com.wanderlei.blog.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wanderlei on 09/06/17.
 */
@Entity
@Table(name = "categorias")
public class Categoria extends AbstractPersistable<Long> {

    @NotBlank
    @Length(min = 3, max = 30)
    @Column(nullable = false, unique = true, length = 30)
    private String descricao;

    @Column(nullable = false, unique = true, length = 30)
    private String permalink;

    @ManyToMany
    @JoinTable(
            name = "postagens_has_categorias",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "postagem_id")
    )
    private List<Postagem> postagems;

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public List<Postagem> getPostagems() {
        return postagems;
    }

    public void setPostagems(List<Postagem> postagems) {
        this.postagems = postagems;
    }
}
