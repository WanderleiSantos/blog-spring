package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Comentario;
import br.com.wanderlei.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by Wanderlei Santos on 21/06/2017.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Transactional(readOnly = false)
    public void save(Comentario comentario){
        Calendar cal = Calendar.getInstance();
        comentario.setDataComentario(cal.getTime());
        repository.save(comentario);
    }

}
