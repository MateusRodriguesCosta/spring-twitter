package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String email;
    private String password;
    private String address;
    private TweetDTO[] tweets;
}
