package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.entities.NotificationEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationEntity toNotificationEntity(NotificationDTO notification);

    NotificationDTO toNotificationDTO(NotificationEntity notification);

    List<NotificationDTO> toNotificationDTO(Iterable<NotificationEntity> list);
}
