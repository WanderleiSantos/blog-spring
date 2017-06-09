package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.repository.PostagemRepository;
import br.com.wanderlei.blog.util.MyReplaceString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wanderlei on 01/06/17.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PostagemService {

    @Autowired
    private PostagemRepository repository;


    public List<Postagem> findAll(){
        return repository.findAll();
    }

    public Postagem findByPermalink(String permalink){
        return repository.findByPermalink(permalink);
    }

    public Postagem findById(Long id){
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public void saveOrUpdate(Postagem postagem){
        if (postagem.getId() == null){
            save(postagem);
        } else {
            update(postagem);
        }
    }

    private void update(Postagem postagem){
        Postagem persistente = repository.findOne(postagem.getId());

        if(!persistente.getTitulo().equals(postagem.getTitulo())){
            persistente.setTitulo(postagem.getTitulo());
        }

        if(!persistente.getTexto().equals(postagem.getTexto())){
            persistente.setTexto(postagem.getTexto());
        }

        if(persistente.getCategorias() != postagem.getCategorias()){
            persistente.setCategorias(postagem.getCategorias());
        }

        repository.save(persistente);
    }

    private void save (Postagem postagem){

        String permalink = MyReplaceString.formatarPermalink(postagem.getTitulo());
        postagem.setPermalink(permalink);

        Calendar cal = Calendar.getInstance();
        postagem.setDataPostagem(cal.getTime());

        repository.save(postagem);
    }

    @Transactional(readOnly = false)
    public void delete(Long id) {
        repository.delete(id);
    }
}
