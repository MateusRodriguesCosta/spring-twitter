package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

    Page<UserEntity> findAll(Pageable pageable);

    Page<UserEntity> findById(String id, Pageable pageable);
}
