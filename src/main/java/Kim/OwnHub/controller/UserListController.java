package Kim.OwnHub.controller;

import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserListController {

    //의존성 주입(DI, Dependency Injection)
    private final UserService userService;


}
