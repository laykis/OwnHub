package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
@Getter @Setter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "TEAM_NAME")
    private String tname;

    @OneToMany(mappedBy = "cteam")
    private List<Content> contents = new ArrayList<>();

    @OneToOne(mappedBy = "team")
    private UserInfo tuid;


}
