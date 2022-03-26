package Kim.OwnHub.controller;


import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
    public String join(){

        return "/user/joinForm";
    }

    @PostMapping("/user/joinpro")
    public String joinpro(JoinForm form){

        String result = "";

        try {
            if (userService.findUserId(form.getUserId()) == true) {
                userjoin.setUserId(form.getUserId());
                userjoin.setUserPw(form.getUserPw());
                userjoin.setUsername(form.getUserName());
                userjoin.setEmail(form.getEmail());
                userjoin.setAuth(form.getAuth());
                userjoin.setRole("0");
                userjoin.setTeam(form.getTeam());

                userService.joining(userjoin);

                result = "";
            } else {


                result = "user/check";
            }
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            return result;
        }
    }
}
