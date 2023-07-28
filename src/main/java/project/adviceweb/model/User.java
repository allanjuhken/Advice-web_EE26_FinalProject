package project.adviceweb.model;

import jakarta.persistence.*;
import lombok.*;

import java.security.PrivateKey;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private Long userId;
    private String displayedName;
    private String email;
    private String password;
    private String answerProvided;
    private String commentsAdded;
    private String questionAsked;
}
