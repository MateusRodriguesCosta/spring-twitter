package myspringapp.springtwitter.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class NotificationEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "_type")
    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "dateTime")
    private String dateTime;

}
