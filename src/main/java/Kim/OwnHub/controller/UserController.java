package Kim.OwnHub.controller;


import Kim.OwnHub.entity.Team;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {


    private UserService userService;
    private UserInfo userjoin = new UserInfo();
    private Team jteam = new Team();

    @GetMapping("/")
    public String main(){

        return "main";
    }

    @PostMapping("user/loginpro")
    public String loginpro(){

        return "";
    }

    @GetMapping("/user/join")
    public String join(Model model){
        model.addAttribute("joinForm", new JoinForm());

        return "/user/joinForm";
    }

    @PostMapping("/user/joinpro")
    public String joinpro(JoinForm form){

        jteam = userService.findTeam(form.getTeam());

        System.out.println(jteam);
        userjoin.setUserId(form.getUserId());
        userjoin.setUserPw(form.getUserPw());
        userjoin.setUsername(form.getUserName());
        userjoin.setEmail(form.getEmail());
        userjoin.setAuth(form.getAuth());
        userjoin.setRole("0");
        userjoin.setTeam(jteam);


        userService.joining(userjoin);

        return "";
    }


}
