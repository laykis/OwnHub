package Kim.OwnHub.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONTENT")
@Getter
public class Content {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTENT_ID")
    private Long id;

    @Column(name = "CONTENT_TITLE")
    private String title;

    @Column(name = "CONTENT_CONTENT")
    private String content;

    @Column(name = "WRITE_DATE")
    private Date wdate;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_NO")
    private Employee cemployee;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team cteam;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board cboard;

}
