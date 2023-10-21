package myspringapp.springtwitter.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myspringapp.springtwitter.dto.NotificationDTO;
import myspringapp.springtwitter.mappers.TwitterMapper;
import myspringapp.springtwitter.repositories.NotificationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final TwitterMapper twitterMapper;

    @Transactional
    public void createNotification(NotificationDTO notification) {
        notificationRepository.save(twitterMapper.toNotificationEntity(notification));
    }

    public NotificationDTO getNotificationById(String id) {
        var notificationEntity = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        return twitterMapper.toNotificationDTO(notificationEntity);
    }

    public void deleteNotificationById(String id) {
        notificationRepository.deleteById(id);
    }

    public List<NotificationDTO> getAllNotificationsByUserId(String id, Pageable pageable) {
        var notificationsEntity = notificationRepository.findAllByUserId(id, pageable);
        return twitterMapper.toNotificationDTO(notificationsEntity);
    }
}
