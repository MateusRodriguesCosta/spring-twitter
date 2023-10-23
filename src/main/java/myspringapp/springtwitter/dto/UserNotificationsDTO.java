package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNotificationsDTO {
    private String id;
    private NotificationDTO[] notifications;
}
