package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE")
@Getter @Setter
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCHEDULE_ID")
    private Long id;

    @Column(name = "START_DATE")
    private String sdate;

    @Column(name = "END_DATE")
    private String edate;

    @Column(name = "SCHEDULE_CONTENT")
    private String scontent;

    @ManyToOne
    @JoinColumn(name = "UID")
    private UserInfo suid;

}
