package Kim.OwnHub.controller;

import Kim.OwnHub.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
}
