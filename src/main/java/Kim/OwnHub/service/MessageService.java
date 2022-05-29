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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public void send(MessageDTO form){

        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

        Message message = new Message.Builder()
                .mcontent(form.getMcontent())
                .mdate(currentTime)
                .sender(form.getSender())
                .receiver(form.getReceiver())
                .status("0")
                .build();

        messageRepository.save(message);

    }

    public List<Message> receiveView(String uid){
        List<Message> message = messageRepository.findByReceiver(uid);

        return message;

    }

    public List<Message> sendView(String uid){
        List<Message> message = messageRepository.findBySender(uid);

        return message;
    }

    public void recDelete(Long id){

        Message message = messageRepository.findById(Long.toString(id));

        if(message.getStatus().equals("1")){
            messageRepository.deleteById(id);
        }else{

            message.changeStatus("2");

        }

    }

    public void sendDelete(Long id) {

        Message message = messageRepository.findById(Long.toString(id));

        if (message.getStatus().equals("2")) {
            messageRepository.deleteById(id);
        } else {

            message.changeStatus("1");

        }
    }

}
