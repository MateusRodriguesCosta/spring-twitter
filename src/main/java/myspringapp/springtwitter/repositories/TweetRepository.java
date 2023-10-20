package myspringapp.springtwitter.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class TweetRepository extends CrudRepository<TweetDTO, String>{
}
