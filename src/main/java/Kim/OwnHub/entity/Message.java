package Kim.OwnHub.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGE")
@Getter
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE_CONTENT")
    private String mcontent;

    @Column(name = "WRITE_DATE")
    private Date mdate;

    @ManyToOne
    private Employee rempno;

    @ManyToOne
    private Employee sempno;

}
