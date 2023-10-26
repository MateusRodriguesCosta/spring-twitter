package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<MessageEntity, String> {

}
