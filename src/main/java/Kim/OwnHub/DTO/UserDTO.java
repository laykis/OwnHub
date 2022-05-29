package Kim.OwnHub.DTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String userId;
    private String userPw;
    private String email;
    private String role;
    private String auth;
    private String team;
}
