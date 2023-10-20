package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.TweetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<TweetEntity, String> {
    Page<TweetEntity> findAllById(Long id);
}
