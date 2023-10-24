package myspringapp.springtwitter.controller;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.*;
import myspringapp.springtwitter.services.MessageService;
import myspringapp.springtwitter.services.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;

    @GetMapping("/{id}")
    public MessageDTO getMessageById(@PathVariable("id") String id) {
        return messageService.getMessageById(id);
    }

    @PostMapping("/")
    public MessageDTO createMessage(@RequestBody MessageDTO message) {
        return messageService.createMessage(message);
    }

    @DeleteMapping("/{id}")
    public void deleteMessageById(@PathVariable("id") String id) {
        messageService.deleteMessageById(id);
    }

}
