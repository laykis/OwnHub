package Kim.OwnHub.controller;


import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    //의존성 주입(DI, Dependency Injection)
    private final UserService userService;


    //로그인 처리용 포스트 매핑
    //localhost:8080/user/loginpro
    @PostMapping("/loginpro")
    public String loginpro(UserDTO form, HttpServletRequest request) {


        //반환 값 저장용 변수
        String result = "";

        try {
            //폼에서 받아온 유저아이디가 DB에 존재하는지 검사
            if (userService.getUserByUserId(form.getUserId()).getUserId() != null) {

                //아이디가 존재하면 비밀번호 비교
                if (form.getUserPw().trim().equals(userService.getUserByUserId(form.getUserId()).getUserPw())) {

                    //아이디, 비밀번호가 일치하면 데이터 전송용 DTO에 유저 정보를 저장
                    UserDTO uinfo = userService.getUserByUserId(form.getUserId());

                    //세션 요청후 유저의 식별키 "uid"와 권한 "auth" 를 세션에 저장
                    HttpSession session = request.getSession();
                    session.setAttribute("uid", uinfo.getId());
                    session.setAttribute("auth", uinfo.getAuth());
                    session.setMaxInactiveInterval(1800);

                    result = "redirect:/home";
                } else {

                    result = "fail";
                }
            } else {

                result = "notfound";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    //localhost:8080/user/join 회원가입 페이지
    @GetMapping("/join")
    public String join(){

        return "user/joinForm";
    }

    //회원 가입 처리용 포스트 매핑
    @PostMapping("/joinpro")
    public String joinpro(UserDTO form){

        //반환 값 저장용 변수
        String result = "";

        try {
            //form 에서 받아온 유저 아이디 중복 검사, 아이디가 존재하지 않으면 값 세팅
            if (userService.getUserByUserId(form.getUserId()).getUserId() == null) {

                //UserInfo 엔티티에 설정해놓은 빌더패턴으로 폼에서 받아온 데이터 세팅
                UserInfo userinfo = new UserInfo.Builder()
                        .username(form.getUsername())
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
            e.printStackTrace();
        }

        return result;
    }
}
