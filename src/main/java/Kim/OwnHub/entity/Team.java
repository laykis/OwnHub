package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

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

    @OneToMany(mappedBy = "cteam")
    private List<Content> contents = new ArrayList<>();

    //기본 생성자
    public Team(){

    }

    //기본 빌더패턴
    public static class Builder{
        private String tname;
        private List<Content> contents;

        public Builder tname(String tname){
            this.tname = tname;
            return this;
        }

        public Builder contents(List<Content> contents){
            this.contents = contents;
            return this;
        }

        public Team build(){
            return new Team(this);
        }
    }

    //값 세팅 메소드
    public Team(Builder builder){

        this.tname = builder.tname;
        this.contents = builder.contents;
    }




}
