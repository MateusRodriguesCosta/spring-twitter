package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.dto.UserTweetsDTO;
import myspringapp.springtwitter.entities.NotificationEntity;
import myspringapp.springtwitter.entities.TweetEntity;
import myspringapp.springtwitter.entities.UserEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationEntity toNotificationEntity(NotificationDTO notification);

    @Named("toNotificationDTO")
    NotificationDTO toNotificationDTO(NotificationEntity notification);

    @IterableMapping(qualifiedByName = "toNotificationDTO")
    List<NotificationDTO> toNotificationDTO(Iterable<NotificationEntity> list);
}
