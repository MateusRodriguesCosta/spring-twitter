package myspringapp.springtwitter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import myspringapp.springtwitter.dto.CommentDTO;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tweet")
public class TweetEntity {
    @Id
    private String id;
    // TODO colocar entity do user
//    private UserDTO user;
    private String value;
    private String date;
    private int likes;
    // TODO colocar entity do comment
    private CommentDTO[] comments;
}
