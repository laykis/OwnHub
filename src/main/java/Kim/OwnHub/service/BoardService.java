package Kim.OwnHub.service;

import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.entity.Content;
import Kim.OwnHub.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    //의존성 주입(DI, Dependency Injection)
    private final BoardRepository boardRepository;

    public void saveContent(ContentDTO form){

        LocalDate now = LocalDate.now();
        DateTimeFormatter dtform = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fnow = now.format(dtform);

        Content content = new Content.Builder()
                .title(form.getTitle())
                .content(form.getContent())
                .cuid(form.getCuid())
                .cboard(form.getCboard())
                .cteam(form.getCteam())
                .wdate(fnow)
                .build();


    }

//    public List<Content> viewList(String BoardId){
//
//        return boardRepository.findByBoardId(BoardId);
//    }

//    public List<Content> searchByTitle(String title){
//
//        return
//    }
//
//    public List<Content> searchByuserName(String userName){
//
//        return
//    }
}
