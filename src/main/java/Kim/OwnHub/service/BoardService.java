package Kim.OwnHub.service;

import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.entity.Content;
import Kim.OwnHub.repository.BoardRepository;
import Kim.OwnHub.repository.ContentRepository;
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
    private final ContentRepository contentRepository;

    //게시글 저장 메소드
    public void saveContent(ContentDTO form){

        //현재시각을 yyyy/MM/dd 형식으로 반환
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtform = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fnow = now.format(dtform);

        //Content 빌더에 값 세팅
        Content content = new Content.Builder()
                .title(form.getTitle())
                .content(form.getContent())
                .cuid(form.getCuid())
                .cboard(form.getCboard())
                .cteam(form.getCteam())
                .wdate(fnow)
                .build();

        //데이터 영속화
        contentRepository.save(content);


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
