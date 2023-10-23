package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.CommentEntity;
import myspringapp.springtwitter.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, String> {

    Page<CommentEntity> findAll(Pageable pageable);

    Page<CommentEntity> findById(String id, Pageable pageable);
}
