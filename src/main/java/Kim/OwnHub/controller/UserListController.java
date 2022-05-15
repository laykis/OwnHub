package Kim.OwnHub.controller;

import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home/userlist")
@RequiredArgsConstructor
public class UserListController {

    private final UserService userService;


}
