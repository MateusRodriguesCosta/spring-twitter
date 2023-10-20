package myspringapp.springtwitter.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    @SequenceGenerator(name = "commentSequence", sequenceName = "SSD.COMMENT_SEQ", allocationSize = 1)
    private String id;
}
