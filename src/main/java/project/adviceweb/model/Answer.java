package project.adviceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long answerId;
    private Long userId;
    private Long questionId;
    private String content;
    private Long evaluation;
}
