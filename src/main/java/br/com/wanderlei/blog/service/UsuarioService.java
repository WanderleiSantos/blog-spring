package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Avatar;
import br.com.wanderlei.blog.entity.Usuario;
import br.com.wanderlei.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wanderlei on 07/05/17.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = false)
    public void save(Usuario usuario){
        if (usuario.getDataCadastro() == null){
            Calendar cal = Calendar.getInstance();
            usuario.setDataCadastro(cal.getTime());
        }

        String hash = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(hash);
        repository.save(usuario);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        repository.delete(id);
    }

    public Usuario findById(Long id){
        return repository.findOne(id);
    }

    public Usuario findByAvatar(Avatar avatar){
        return repository.findByAvatar(avatar);
    }

    public Usuario findByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    @Transactional(readOnly = false)
    public void updateNomeAndEmail(Usuario usuario) {
        repository.updateNomeAndEmail(usuario.getNome(), usuario.getEmail(), usuario.getId());
    }

    @Transactional(readOnly = false)
    public void updateSenha(Usuario usuario) {
        String hash = new BCryptPasswordEncoder().encode(usuario.getSenha());
        usuario.setSenha(hash);
        repository.updateSenha(usuario.getSenha(), usuario.getId());
    }
}
