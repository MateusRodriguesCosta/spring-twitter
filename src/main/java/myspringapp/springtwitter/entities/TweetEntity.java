package myspringapp.springtwitter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tweet")
public class TweetEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "_value")
    private String value;

    @Column(name = "date")
    private String date;

    @Column(name = "likes")
    private int likes;

    @OneToMany(mappedBy = "tweet", fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

}
