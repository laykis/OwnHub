package Kim.OwnHub.controller;

import Kim.OwnHub.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home/board")
@RequiredArgsConstructor
public class BoardController {

    //localhost:8080/home/board 페이지에서 들어오는 요청 처리용 컨트롤러

    //의존성 주입(DI, Dependency Injection)
    private final BoardRepository boardRepository;


}
