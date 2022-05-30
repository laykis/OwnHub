package Kim.OwnHub.entity;

import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.repository.ContentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

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
    private String wdate;

    @Column(name= "Content_TEAM")
    private String cteam;

    @Column(name="Content_BOARD")
    private String cboard;

    @Column(name ="Content_UID")
    private String cuid;


    public void updateContent(ContentDTO contentDTO){

        this.title = contentDTO.getTitle();
        this.content = contentDTO.getContent();
        this.wdate = contentDTO.getWdate();
    }



    public Content(){

    }

    public static class Builder{


        private String title;
        private String content;
        private String wdate;
        private String cteam;
        private String cboard;
        private String cuid;

        public Builder title(String title){

            this.title = title;
            return this;
        }

        public Builder content(String content){

            this.content = content;
            return this;
        }

        public Builder wdate(String wdate){

            this.wdate = wdate;
            return this;
        }

        public Builder cteam(String cteam){

            this.cteam = cteam;
            return this;
        }

        public Builder cboard(String cboard){

            this.cboard = cboard;
            return this;
        }

        public Builder cuid(String cuid){

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
