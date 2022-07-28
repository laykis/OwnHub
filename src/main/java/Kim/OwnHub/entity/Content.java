package Kim.OwnHub.entity;

import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.repository.ContentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    //게시글 수정 용 세터
    public void updateContent(ContentDTO contentDTO){

        this.title = contentDTO.getTitle();
        this.content = contentDTO.getContent();
        this.wdate = contentDTO.getWdate();
    }

    public ContentDTO convert(Content content){
        ContentDTO result = new ContentDTO();

        result.setId(content.getId());
        result.setContent(content.getContent());
        result.setTitle(content.getTitle());
        result.setWdate(content.getWdate());
        result.setCteam(content.getCteam());
        result.setCboard(content.getCboard());
        result.setCuid(content.getCuid());

        return result;
    }

    public List<ContentDTO> listConvert(List<Content> contents){

        List<ContentDTO> result = new ArrayList<>();


        for(int i = 0; i < contents.size(); i++){

            this.id = contents.get(i).getId();
            this.title = contents.get(i).getTitle();
            this.content = contents.get(i).getContent();
            this.wdate = contents.get(i).getWdate();
            this.cteam = contents.get(i).getCteam();
            this.cboard = contents.get(i).getCboard();
            this.cuid = contents.get(i).getCuid();

            ContentDTO cv = convert(this);
            result.add(i, cv);

        }

        return result;
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
