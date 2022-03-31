package Kim.OwnHub.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinDTO {
    //회원가입 데이터 전송용 객체

    private String userId;

    private String userPw;

    private String userName;

    private String email;

    private String team;

    private String auth;
}