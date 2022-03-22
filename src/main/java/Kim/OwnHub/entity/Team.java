package Kim.OwnHub.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEAM")
@Getter
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "TEAM_NAME")
    private String tname;

    @OneToMany(mappedBy = "team")
    private List<Employee> employeeList = new ArrayList<>();

    @OneToMany(mappedBy = "cteam")
    private List<Content> contents = new ArrayList<>();


}
