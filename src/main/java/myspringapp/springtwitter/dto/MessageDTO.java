package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String id;
    private String value;
    private String dateTime;
    private UserDTO from;
    private UserDTO to;
}
