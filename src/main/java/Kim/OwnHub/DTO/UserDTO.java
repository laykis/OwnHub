package Kim.OwnHub.DTO;


import Kim.OwnHub.entity.UserInfo;
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

    public void convert(UserInfo user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.auth = user.getAuth();
        this.team = user.getTeam();
    }


}
