package Kim.OwnHub.entity;

import Kim.OwnHub.DTO.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERINFO")
@Getter
public class UserInfo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_PW")
    private String userPw;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "AUTHORITY")
    private String auth;

    @Column(name = "TEAM_ID")
    private String team;


    public UserDTO convert(UserInfo userInfo){

        UserDTO userDTO = new UserDTO();

        userDTO.setUsername(userInfo.getUsername());
        userDTO.setUserId(userInfo.getUserId());
        userDTO.setUserPw(userInfo.getUserPw());
        userDTO.setEmail(userInfo.getEmail());
        userDTO.setRole(userInfo.getRole());
        userDTO.setAuth(userInfo.getAuth());
        userDTO.setTeam(userInfo.getTeam());

        return userDTO;
    }



    //기본 생성자
    public UserInfo(){

    }
    //엔티티 객체 값 설정을 위한 빌더 패턴
    public static class Builder{

        private String username;
        private String userId;
        private String userPw;
        private String email;
        private String role;
        private String auth;
        private String team;



        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder userId(String userId){
            this.userId = userId;
            return this;
        }

        public Builder userPw(String userPw){
            this.userPw = userPw;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder role(String role){
            this.role = role;
            return this;
        }

        public Builder auth(String auth){
            this.auth = auth;
            return this;
        }

        public Builder team(String team){
            this.team = team;
            return this;
        }





        //값 세팅 후에 본 객체에 값을 세팅해주는 메소드
        public UserInfo build(){
            return new UserInfo(this);
        }


    }

    //빌더 클래스에 세팅된 값을 엔티티에 값 세팅
    public UserInfo(Builder builder) {
        this.username = builder.username;
        this.userId = builder.userId;
        this.userPw = builder.userPw;
        this.email = builder.email;
        this.role = builder.role;
        this.auth = builder.auth;
        this.team = builder.team;



    }
}
