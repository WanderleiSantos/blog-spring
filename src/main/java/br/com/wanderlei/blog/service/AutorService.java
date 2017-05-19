package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Autor;
import br.com.wanderlei.blog.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wanderlei on 18/05/17.
 */

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public void save(Autor autor){
        repository.save(autor);
    }

    public List<Autor> findAll(){
        return repository.findAll();
    }

    public Autor findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Autor findById(Long id){
        return repository.findOne(id);
    }


}
