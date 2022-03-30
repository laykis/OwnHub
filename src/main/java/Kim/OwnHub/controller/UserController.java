package Kim.OwnHub.controller;


import Kim.OwnHub.DTO.JoinDTO;
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

    //localhost:8080 접속 시 메인페이지
    @GetMapping("/")
    public String main(){

        return "main";
    }

    //로그인 처리용 포스트 매핑
    @PostMapping("user/loginpro")
    public String loginpro(){

        return "";
    }

    //localhost:8080/user/join 회원가입 페이지
    @GetMapping("/user/join")
    public String join(){

        return "/user/joinForm";
    }

    //회원 가입 처리용 포스트 매핑
    @PostMapping("/user/joinpro")
    public String joinpro(JoinDTO form){

        //반환 값 저장용 변수
        String result = "";

        try {
            //form 에서 받아온 유저 아이디 중복 검사, 아이디가 존재하지 않으면 값 세팅
            if (userService.findUserId(form.getUserId()) == true) {

                //UserInfo 엔티티에 설정해놓은 빌더패턴으로 폼에서 받아온 데이터 세팅
                UserInfo userinfo = new UserInfo.Builder()
                        .username(form.getUserName())
                        .userId(form.getUserId())
                        .userPw(form.getUserPw())
                        .email(form.getEmail())
                        .role("0")
                        .auth(form.getAuth())
                        .team(form.getTeam())
                                .build();

                //세팅된 데이터 영속화
                userService.joining(userinfo);

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
