package br.com.wanderlei.blog.service;

import br.com.wanderlei.blog.entity.Avatar;
import br.com.wanderlei.blog.repository.AvatarRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by wanderlei on 07/05/17.
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AvatarService {

    private static final Logger LOGGER = Logger.getLogger(AvatarService.class);

    @Autowired
    private AvatarRepository repository;

    @Transactional(readOnly = false)
    public void saveOrUpdate(Avatar avatar){
        repository.save(avatar);
    }

    public Avatar getAvatarByUpload(MultipartFile file){
        Avatar avatar = new Avatar();

        if (file != null && file.getSize() > 0){
            try {
                avatar.setTitulo(file.getOriginalFilename());
                avatar.setTipo(file.getContentType());
                avatar.setAvatar(file.getBytes());
            } catch (IOException e) {
                LOGGER.error("Erro AvatarService: " + e.getMessage());
            }
        }

        return avatar;
    }

    public Avatar findById(Long id) {
        return repository.findOne(id);
    }
}
