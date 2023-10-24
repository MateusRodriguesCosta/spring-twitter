package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMessagesDTO {
    private String id;
    private MessageDTO[] messages;
}
