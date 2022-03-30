package Kim.OwnHub.entity;

import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;


    public Message(){

    }

    public static class Builder{
        private String mcontent;
        private Date mdate;
        private String sender;
        private String receiver;


        public Builder mcontent(){
            this.mcontent = mcontent;
            return this;
        }

        public Builder mdate(){
            this.mdate = mdate;
            return this;
        }

        public Builder sender(){
            this.sender = sender;
            return this;
        }

        public Builder receiver(){
            this.receiver = receiver;
            return this;
        }

        public Message build(){
            return new Message(this);
        }

    }

    public Message(Builder builder){
        this.mcontent = builder.mcontent;
        this.mdate = builder.mdate;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
    }
}
