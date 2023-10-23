package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TweetDTO {
    private String id;
    private UserDTO user;
    private String value;
    private String date;
    private int likes;
}
