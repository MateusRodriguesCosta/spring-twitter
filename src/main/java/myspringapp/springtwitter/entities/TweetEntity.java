package myspringapp.springtwitter.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "value")
    private String value;

    @Column(name = "date")
    private String date;

    @Column(name = "likes")
    private int likes;

//    @OneToMany(mappedBy = "tweet", fetch = FetchType.LAZY)
//    @JoinColumn(name = "tweet_id", nullable = false, insertable = false, updatable = false)
//    private CommentEntity comments;

}
