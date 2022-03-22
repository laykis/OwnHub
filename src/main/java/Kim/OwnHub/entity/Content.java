package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CONTENT")
@Getter @Setter
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
    @JoinColumn(name = "TEAM_ID")
    private Team cteam;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board cboard;

    @ManyToOne
    @JoinColumn(name = "UID")
    private UserInfo cuid;

}
