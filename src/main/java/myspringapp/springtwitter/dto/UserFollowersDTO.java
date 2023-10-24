package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowersDTO {
    private String id;
    private UserDTO[] followers;
}
