package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERINFO")
@Getter @Setter
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

    @OneToMany(mappedBy = "cuid")
    private List<Content> Ucontents = new ArrayList<>();

    @OneToMany(mappedBy = "suid")
    private List<Schedule> Schedules = new ArrayList<>();


}
