package myspringapp.springtwitter.repositories;

import myspringapp.springtwitter.entities.NotificationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<NotificationEntity, String> {

    Page<NotificationEntity> findAllByUserId(String id, Pageable pageable);
}
