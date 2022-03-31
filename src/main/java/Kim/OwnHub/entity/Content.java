package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "TEAM_ID")
    private Team cteam;

    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board cboard;

    @ManyToOne
    @JoinColumn(name = "UID")
    private UserInfo cuid;

    public Content(){

    }

    public static class Builder{


        private String title;
        private String content;
        private Date wdate;
        private Team cteam;
        private Board cboard;
        private UserInfo cuid;

        public Builder title(String title){

            this.title = title;
            return this;
        }

        public Builder content(String content){

            this.content = content;
            return this;
        }

        public Builder wdate(Date wdate){

            this.wdate = wdate;
            return this;
        }

        public Builder cteam(Team cteam){

            this.cteam = cteam;
            return this;
        }

        public Builder cboard(Board board){

            this.cboard = cboard;
            return this;
        }

        public Builder cuid(UserInfo cuid){

            this.cuid = cuid;
            return this;
        }
        public Content build(){
            return new Content(this);
        }

    }

    public Content(Builder builder){

        this.title = builder.title;
        this.content = builder.content;
        this.wdate = builder.wdate;
        this.cteam = builder.cteam;
        this.cboard = builder.cboard;
        this.cuid = builder.cuid;
    }



}
