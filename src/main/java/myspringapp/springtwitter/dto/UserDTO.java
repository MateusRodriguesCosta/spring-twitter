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
    private String phone;
    private String bio;
    private String joinedDate;
    private boolean verifiedAccount;
}
