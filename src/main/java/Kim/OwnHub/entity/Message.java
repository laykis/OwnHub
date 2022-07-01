package Kim.OwnHub.entity;

import Kim.OwnHub.repository.MessageRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
    private String mdate;

    @Column(name = "SENDER")
    private String sender;

    @Column(name = "RECEIVER")
    private String receiver;

    //0 = 삭제요청 없음, 1 = 송신자 삭제요청, 2 = 수신자 삭제요청.
    @Column(name = "STATUS")
    private String status;

    //status(송신자 삭제, 수신자 삭제, 완전 삭제) 변경 메소드
    public void changeStatus(String status){
        this.status = status;
    }

    public Message(){

    }

    public static class Builder{
        private String mcontent;
        private String mdate;
        private String sender;
        private String receiver;
        private String status;


        public Builder mcontent(String mcontent){
            this.mcontent = this.mcontent;
            return this;
        }

        public Builder mdate(String mdate){
            this.mdate = mdate;
            return this;
        }

        public Builder sender(String sender){
            this.sender = this.sender;
            return this;
        }

        public Builder receiver(String receiver){
            this.receiver = receiver;
            return this;
        }

        public Builder status(String status){
            this.status = status;
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
        this.status = builder.status;
    }
}
