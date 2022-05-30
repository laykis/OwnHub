package Kim.OwnHub.service;

import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.entity.Content;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.BoardRepository;
import Kim.OwnHub.repository.ContentRepository;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    //의존성 주입(DI, Dependency Injection)
    private final BoardRepository boardRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;

    //게시글 저장 메소드
    public void saveContent(ContentDTO form){

        //현재시각을 yyyy/MM/dd 형식으로 반환

        String fnow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

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

    //게시글 수정 시 게시글 호출 용
    public Optional<Content> viewOne(String id){

        Optional<Content> content = contentRepository.findById(Long.parseLong(id));

        return content;
    }

    public void updateCon(ContentDTO contentDTO){

        Content con = contentRepository.findById(contentDTO.getId().toString());

        con.updateContent(contentDTO);


    }
    public List<Content> viewList(String boardId){

        List<Content> result = contentRepository.findByCboard(boardId);

        return result;
    }

    public List<Content> searchByTitle(String title){

        List<Content> result = contentRepository.findByTitle(title);

        return result;
    }

    public List<Content> searchByUserName(String userName){

        List<UserInfo> uinfo = userRepository.findIdByUsername(userName);

        List<String> uidlist = new ArrayList<>();
        List<Content> result = new ArrayList<>();

        for(int i=0; i<uinfo.size(); i++){
            uidlist.add(Long.toString(uinfo.get(i).getId()));
        }

        for(int i=0; i<uidlist.size(); i++){

            List<Content> userlist = contentRepository.findByCuid(uidlist.get(i));

            for(int j=0; j<userlist.size(); j++){

                result.add(userlist.get(j));
            }
        }

        return result;
    }
}
