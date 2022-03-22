package Kim.OwnHub.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "EMPLOYEE")
@Getter
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_NO")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMPLOYEE_NAME")
    private String ename;

    @Column(name = "JOIN_DATE")
    private Date jdate;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "IS_AUTHORITY")
    private String eauth;

    @Column(name = "LAST_LOGIN")
    private Date lastdate;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "IMAGE_URL")
    private String iurl;

    @OneToMany(mappedBy = "semployee")
    private List<Schedule> schedule = new ArrayList<>();

    @OneToMany(mappedBy = "cemployee")
    private List<Content> contents = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "AUTHORITY_ID")
    private Authority authority;

    @OneToMany(mappedBy = "rempno")
    private List<Message> rmessage = new ArrayList<>();

    @OneToMany(mappedBy = "sempno")
    private List<Message> smessage = new ArrayList<>();


}
