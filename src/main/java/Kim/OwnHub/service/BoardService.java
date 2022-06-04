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
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    //의존성 주입(DI, Dependency Injection)
    private final BoardRepository boardRepository;
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;

    //게시글 저장 메소드
    public void saveContent(ContentDTO form){


        try{

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

        }catch (Exception e){
            System.out.println(e);
        }





    }

    //게시글 수정 시 게시글 호출 용
    public Optional<Content> viewOne(String id){

        Optional<Content> content = Optional.of(new Content());

        try{
            //수정 요청 된 게시글의 아이디를 받아서 내용 반환
            content = contentRepository.findById(Long.parseLong(id));


        }catch (Exception e){
            System.out.println(e);
        }

        return content;

    }

    //수정 된 게시글 업데이트
    public void updateCon(ContentDTO contentDTO){

        try{

            //수정 완료 시 해당 Content row 호출
            Optional<Content> con = contentRepository.findById(contentDTO.getId());

            Content content = con.orElseThrow(() -> new NoSuchElementException());

            content.updateContent(contentDTO);

        }catch (Exception e){
            System.out.println(e);
        }



    }

    //게시글 목록 열람
    public List<Content> viewList(String boardId){

        List<Content> result = new ArrayList<>();

        try{

            //게시판 진입 시 게시판 아이디를 받아 전체 목록 호출(ex 자유게시판, 부서게시판)
            result = contentRepository.findByCboard(boardId);

        }catch (Exception e){
            System.out.println(e);
        }



        return result;
    }

    //게시글 제목 검색
    public List<Content> searchByTitle(String title){

        List<Content> result = new ArrayList<>();

        try{
            //게시글 제목을 받아 해당 제목 게시글 전부 호출
            result = contentRepository.findByTitle(title);

        }catch (Exception e){
            System.out.println(e);
        }



        return result;
    }


    //게시글 사용자 이름 검색
    public List<Content> searchByUserName(String userName){

        //데이터 처리용 리스트
        List<UserInfo> uinfo = new ArrayList<>();
        List<String> uidlist = new ArrayList<>();
        List<Content> result = new ArrayList<>();

        try{
            //사용자 이름에 해당하는 유저 전부 호출
            uinfo = userRepository.findIdByUsername(userName);

            //해당 유저의 Id만 리스트에 저장
            for(int i=0; i<uinfo.size(); i++){
                uidlist.add(Long.toString(uinfo.get(i).getId()));
            }

            //동명다인의 수 대로 모든 정보를 저장하기 위한 포문
            for(int i=0; i<uidlist.size(); i++){

                //i번째 해당하는 유저의 게시글 전부 리스트에 저장
                List<Content> userlist = contentRepository.findByCuid(uidlist.get(i));


                for(int j=0; j<userlist.size(); j++){

                    //데이터 반환 용 리스트에 i번째 유저의 게시글 추가
                    result.add(userlist.get(j));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        return result;
    }
}
