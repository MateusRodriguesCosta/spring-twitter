package myspringapp.springtwitter.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TweetCommentsDTO {
    private String id;
    private CommentDTO[] comments;
}
