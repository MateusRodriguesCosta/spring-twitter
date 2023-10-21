package myspringapp.springtwitter.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tweet_comment")
public class CommentEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet_id", nullable = false, insertable = false, updatable = false)
    private TweetEntity tweet;

    @Column(name = "_value")
    private String value;

    @Column(name = "date")
    private String date;

    @Column(name = "likes")
    private int likes;
}
