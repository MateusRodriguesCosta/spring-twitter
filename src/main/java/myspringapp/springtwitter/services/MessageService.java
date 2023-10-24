package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.MessageDTO;
import myspringapp.springtwitter.dto.MessageDTO;
import myspringapp.springtwitter.mappers.MessageMapper;
import myspringapp.springtwitter.mappers.MessageMapper;
import myspringapp.springtwitter.repositories.MessageRepository;
import myspringapp.springtwitter.repositories.MessageRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Transactional
    public MessageDTO createMessage(MessageDTO message) {
        var messageEntity = messageRepository.save(messageMapper.toMessageEntity(message));
        return messageMapper.toMessageDTO(messageEntity);
    }

    public MessageDTO getMessageById(String id) {
        var messageEntity = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        return messageMapper.toMessageDTO(messageEntity);
    }

    public void deleteMessageById(String id) {
        messageRepository.deleteById(id);
    }

}
