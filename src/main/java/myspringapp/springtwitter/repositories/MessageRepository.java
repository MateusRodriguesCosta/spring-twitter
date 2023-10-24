package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.MessageEntity;
import myspringapp.springtwitter.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, String> {

    Page<MessageEntity> findAll(Pageable pageable);

    Page<MessageEntity> findById(String id, Pageable pageable);
}
