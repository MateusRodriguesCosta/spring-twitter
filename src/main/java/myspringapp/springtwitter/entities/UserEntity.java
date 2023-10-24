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

    @Column(name = "phone")
    private String phone;

    @Column(name = "bio")
    private String bio;

    @Column(name = "joinedDate")
    private String joinedDate;

    @Column(name = "verifiedAccount")
    private boolean verifiedAccount;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<TweetEntity> tweets;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<NotificationEntity> notifications;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<MessageEntity> messages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "following",
            joinColumns = @JoinColumn(name = "user_follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<UserEntity> following;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "user_followers_id"),
            inverseJoinColumns = @JoinColumn(name = "followers_id"))
    private List<UserEntity> followers;

}
