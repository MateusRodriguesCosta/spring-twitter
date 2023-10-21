package myspringapp.springtwitter.controller;

import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.services.NotificationService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    @GetMapping("/")
    public List<NotificationDTO> getAllNotificationsByUserId(String id, Pageable pageable) {
        return notificationService.getAllNotificationsByUserId(id, pageable);
    }

    @GetMapping("/{id}")
    public NotificationDTO getNotificationById(@PathVariable String id) {
        return notificationService.getNotificationById(id);
    }

    @PostMapping("/")
    public void createNotification(@RequestBody NotificationDTO notification) {
        notificationService.createNotification(notification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotificationById(@PathVariable String id) {
        notificationService.deleteNotificationById(id);
    }
}
