package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.*;
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
public interface UserMapper {

    UserTweetsDTO toUserTweetsDTO(UserEntity user);

    UserNotificationsDTO toUserNotificationsDTO(UserEntity user);

    UserEntity toUserEntity(UserDTO user);

    @Named("toUserDTO")
    UserDTO toUserDTO(UserEntity user);

    @IterableMapping(qualifiedByName = "toUserDTO")
    List<UserDTO> toUserDTO(Iterable<UserEntity> list);

}
