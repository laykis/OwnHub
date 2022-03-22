package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARD")
@Getter @Setter
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_NAME")
    private String bname;

    @Column(name = "BOARD_AUTHORITY")
    private String bauth;

    @Column(name = "IS_TEAM")
    private String bteam;

    @OneToMany(mappedBy = "cboard")
    private List<Content> contents = new ArrayList<>();
}
