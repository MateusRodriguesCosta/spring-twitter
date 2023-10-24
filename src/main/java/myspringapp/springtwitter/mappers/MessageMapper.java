package myspringapp.springtwitter.mappers;

import myspringapp.springtwitter.dto.MessageDTO;
import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.entities.MessageEntity;
import myspringapp.springtwitter.entities.NotificationEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageEntity toMessageEntity(MessageDTO message);

    MessageDTO toMessageDTO(MessageEntity message);

    List<MessageDTO> toMessageDTO(Iterable<MessageEntity> list);
}
