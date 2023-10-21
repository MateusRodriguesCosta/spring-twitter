package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.dto.TweetDTO;
import myspringapp.springtwitter.dto.UserDTO;
import myspringapp.springtwitter.entities.NotificationEntity;
import myspringapp.springtwitter.entities.TweetEntity;
import myspringapp.springtwitter.entities.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Component
@Mapper(componentModel = "spring")
public interface TwitterMapper {

    TweetDTO toTweetDTO(TweetEntity tweet);

    TweetEntity toTweetEntity(TweetDTO tweet);

    UserDTO toUserDTO(UserEntity user);

    UserEntity toUserEntity(UserDTO user);

    NotificationDTO toNotificationDTO(NotificationEntity notification);

    NotificationEntity toNotificationEntity(NotificationDTO notification);

    default List<TweetDTO> toTweetDTO(Iterable<TweetEntity> list) {
        return StreamSupport.stream(list.spliterator(), false).map(this::toTweetDTO).collect(toList());
    }

    default List<UserDTO> toUserDTO(Iterable<UserEntity> list) {
        return StreamSupport.stream(list.spliterator(), false).map(this::toUserDTO).collect(toList());
    }

    default List<NotificationDTO> toNotificationDTO(Iterable<NotificationEntity> list) {
        return StreamSupport.stream(list.spliterator(), false).map(this::toNotificationDTO).collect(toList());
    }
}
