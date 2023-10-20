package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.TweetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends CrudRepository<TweetEntity, String> {

    Page<TweetEntity> findAllByUserId(String id, Pageable pageable);

    @Query(value = "SELECT * FROM tweet WHERE user = :id", nativeQuery = true)
    Page<TweetEntity> findUserFeed(@Param("id") String id, Pageable pageable);
}
