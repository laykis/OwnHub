package Kim.OwnHub.controller;

import Kim.OwnHub.DTO.BoardDTO;
import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.entity.Content;
import Kim.OwnHub.repository.BoardRepository;
import Kim.OwnHub.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    //localhost:8080/home/board 페이지에서 들어오는 요청 처리용 컨트롤러

    //의존성 주입(DI, Dependency Injection)
    private final BoardService boardService;

    @GetMapping("/home/board/content")
    public List<ContentDTO> viewList(){

        System.out.println("pass");
        Content content = new Content();

        List<ContentDTO> result = content.listConvert(boardService.viewList("0"));

        System.out.println(result.get(0));

        try{

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }



}
