package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.*;
import myspringapp.springtwitter.entities.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserTweetsDTO toUserTweetsDTO(UserEntity user);

    UserNotificationsDTO toUserNotificationsDTO(UserEntity user);

    UserCommentsDTO toUserCommentsDTO(UserEntity user);

    UserMessagesDTO toUserMessagesDTO(UserEntity user);

    UserFollowingDTO toUserFollowingDTO(UserEntity user);

    UserFollowersDTO toUserFollowersDTO(UserEntity user);

    UserEntity toUserEntity(UserDTO user);

    UserDTO toUserDTO(UserEntity user);

    List<UserDTO> toUserDTO(Iterable<UserEntity> list);

}
