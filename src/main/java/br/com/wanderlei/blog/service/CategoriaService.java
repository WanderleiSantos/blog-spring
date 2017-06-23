package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Categoria;
import br.com.wanderlei.blog.repository.CategoriaRepository;
import br.com.wanderlei.blog.util.MyReplaceString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wanderlei on 09/06/17.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findByDescricao(String descricao){
        return repository.findByDescricao(descricao);
    }

    public Categoria findById(Long id){
        return repository.findOne(id);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        repository.delete(id);
    }

    @Transactional(readOnly = false)
    public void saveOrUpdate(Categoria categoria){
        String permalink = MyReplaceString.formatarPermalink(categoria.getDescricao());
        categoria.setPermalink(permalink);
        repository.save(categoria);
    }

    public Page<Categoria> findByPagination(int page, int size){
        Pageable pageable = new PageRequest(page, size);
        return repository.findAllByOrderByDescricaoAsc(pageable);
    }
}
