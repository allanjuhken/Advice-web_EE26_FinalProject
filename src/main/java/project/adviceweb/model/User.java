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
            GenerationType.IDENTITY)
    private Long userId;
    private String displayedName;
    private String email;
    private String password;
    private String answerType;
    private String commentsAdded;
    private String questionAsked;
}
