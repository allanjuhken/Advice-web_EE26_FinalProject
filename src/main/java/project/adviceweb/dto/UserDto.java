package project.adviceweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String displayedName;
    private String email;
    private String password;
}
