package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BOARD")
@Getter
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

    public Board(){

    }

    public static class Builder{
        private String bname;
        private String bauth;
        private String bteam;
        private List<Content> contents;

        public Builder bname(String bname){
            this.bname = bname;
            return this;
        }

        public Builder bauth(String bauth){
            this.bauth = bauth;
            return this;
        }

        public Builder bteam(String bteam){
            this.bteam = bteam;
            return this;
        }

        public Builder contents(List<Content> contents){
            this.contents = contents;
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }

    public Board(Builder builder){
        this.bname = builder.bname;
        this.bauth = builder.bauth;
        this.bteam = builder.bteam;
        this.contents = builder.contents;
    }
}
