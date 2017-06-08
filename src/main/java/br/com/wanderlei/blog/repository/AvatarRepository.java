package br.com.wanderlei.blog.repository;

import br.com.wanderlei.blog.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wanderlei on 07/05/17.
 */
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
}
