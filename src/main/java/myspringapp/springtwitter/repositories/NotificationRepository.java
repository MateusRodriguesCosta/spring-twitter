package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<NotificationEntity, String> {

    Page<NotificationEntity> findAllByUserId(String id, Pageable pageable);
}
