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

    @Column(name = "SCHEDULE_CONTENT")
    private String scontent;

    @ManyToOne
    @JoinColumn(name = "UID")
    private UserInfo suid;

    public Schedule(){

    }

    public static class Builder{
        private String sdate;
        private String edate;
        private String scontent;
        private UserInfo suid;


        public Builder sdate(String sdate){
            this.sdate = sdate;
            return this;
        }

        public Builder edate(String edate){
            this.edate = edate;
            return this;
        }

        public Builder scontent(String scontent){
            this.scontent = scontent;
            return this;
        }

        public Builder suid(UserInfo suid){
            this.suid = suid;
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
    }

}
