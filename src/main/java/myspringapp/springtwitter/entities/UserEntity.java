package myspringapp.springtwitter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "twitter_user")
public class UserEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<TweetEntity> tweets;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<NotificationEntity> notifications;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "following",
            joinColumns = @JoinColumn(name = "user_follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<UserEntity> following;

}
