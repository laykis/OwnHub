package Kim.OwnHub.controller;


import Kim.OwnHub.entity.Team;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;
    private UserInfo userjoin = new UserInfo();


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

        if(userService.findUserId(form.getUserId()) == true){
            userjoin.setUserId(form.getUserId());
            userjoin.setUserPw(form.getUserPw());
            userjoin.setUsername(form.getUserName());
            userjoin.setEmail(form.getEmail());
            userjoin.setAuth(form.getAuth());
            userjoin.setRole("0");
            userjoin.setTeam(form.getTeam());

            userService.joining(userjoin);

            return "";
        }else{


            return "/user/check";
        }


    }


}
