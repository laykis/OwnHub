package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SCHEDULE")
@Getter
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCHEDULE_ID")
    private Long id;

    @Column(name = "START_DATE")
    private String sdate;

    @Column(name = "END_DATE")
    private String edate;

    @Column(name = "SCHEDULE_TITLE")
    private String stitle;

    @Column(name = "SCHEDULE_CONTENT")
    private String scontent;

    @Column(name = "STATUS")
    private String s_status;

    @Column(name = "S_UID")
    private String suid;

    public Schedule(){

    }

    public static class Builder{
        private String sdate;
        private String edate;
        private String stitle;
        private String scontent;
        private String s_status;
        private String suid;


        public Builder sdate(String sdate){
            this.sdate = sdate;
            return this;
        }

        public Builder edate(String edate){
            this.edate = edate;
            return this;
        }

        public Builder stitle(String stitle){
            this.stitle = stitle;
            return this;
        }

        public Builder scontent(String scontent){
            this.scontent = scontent;
            return this;
        }

        public Builder suid(String suid){
            this.suid = suid;
            return this;
        }

        public Builder s_status(String s_status){
            this.s_status = s_status;
            return this;
        }

        public Schedule build(){
            return new Schedule(this);
        }
    }

    public Schedule(Builder builder){

        this.sdate = builder.sdate;
        this.edate = builder.edate;
        this.scontent = builder.scontent;
        this.suid = builder.suid;
        this.s_status = builder.s_status;
        this.stitle = builder.stitle;
    }

}
