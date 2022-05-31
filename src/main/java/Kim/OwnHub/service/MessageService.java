package Kim.OwnHub.service;

import Kim.OwnHub.DTO.MessageDTO;
import Kim.OwnHub.entity.Message;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.MessageRepository;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    //메시지 전송 메소드
    public void send(MessageDTO form){

        try{

            //현재 시각 저장
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

            //메시지 값 세팅
            Message message = new Message.Builder()
                    .mcontent(form.getMcontent())
                    .mdate(currentTime)
                    .sender(form.getSender())
                    .receiver(form.getReceiver())
                    .status("0")
                    .build();

            //메시지 영속화
            messageRepository.save(message);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    //수신함 열람 용 메소드
    public List<Message> receiveView(String uid){

        List<Message> message = new ArrayList<>();

        try{

            //요청 사용자 uid에 해당하는 메시지 호출
            message = messageRepository.findByReceiver(uid);

        }catch (Exception e){
            System.out.println(e);
        }

        return message;

    }

    //송신함 열람 용 메소드
    public List<Message> sendView(String uid){


        List<Message> message = new ArrayList<>();

        try{

            //요청 사용자 uid에 해당하는 메시지 호출
            message = messageRepository.findBySender(uid);

        }catch (Exception e){
            System.out.println(e);
        }

        return message;
    }

    //수신함 삭제 메소드
    public void recDelete(Long id){

        try{

            //
            Optional<Message> me = messageRepository.findById(id);

            Message message = me.orElseThrow(() -> new NoSuchElementException());


            if(message.getStatus().equals("1")){
                messageRepository.deleteById(id);
            }else{

                message.changeStatus("2");

            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void sendDelete(Long id) {

        try{

            Optional<Message> me = messageRepository.findById(id);

            Message message = me.orElseThrow(() -> new NoSuchElementException());

            if (message.getStatus().equals("2")) {
                messageRepository.deleteById(id);
            } else {

                message.changeStatus("1");

            }

        }catch (Exception e){
            System.out.println(e);
        }

    }

}
