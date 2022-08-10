package Kim.OwnHub.controller;

import Kim.OwnHub.DTO.BoardDTO;
import Kim.OwnHub.DTO.ContentDTO;
import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.Content;
import Kim.OwnHub.repository.BoardRepository;
import Kim.OwnHub.service.BoardService;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    //localhost:8080/home/board 페이지에서 들어오는 요청 처리용 컨트롤러

    //의존성 주입(DI, Dependency Injection)
    private final BoardService boardService;
    private final UserService userService;

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

    @PostMapping("/board/submit")
    public String postCon(ContentDTO form, HttpServletRequest req){

        System.out.println(form.getCboard());
        System.out.println(form.getContent());
        System.out.println(form.getTitle());
        String result = "";

//        HttpSession session = req.getSession();
//        Long uid = Long.parseLong(session.getAttribute("uid").toString());
//        UserDTO userDTO = userService.getUserByUid(uid);
//        form.setCuid(uid.toString());
//        form.setCteam(userDTO.getTeam());

        form.setCuid("19");
        form.setCteam("asd");
        try{
            boardService.saveContent(form);

            result = "sucsess";
        }catch (Exception e){
            e.printStackTrace();
            result = "fail";
        }
        System.out.println(result);
        return result;


    }



}
