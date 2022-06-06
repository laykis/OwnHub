package Kim.OwnHub.controller;

import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    //localhost:8080/home 페이지에서 들어오는 요청 처리용 컨트롤러

    //의존성 주입(DI, Dependency Injection)
    private final UserService userService;

    //localhost:8080/home URL 요청시 home.html view
    @GetMapping("/")
    public String home() {

        return "";
    }

    //클릭 시 localhost:8080으로 돌아가는 홈버튼 처리용 포스트매핑
    @PostMapping("/goback")
    public String goBackHome(){

        return "redirect:/";
    }

    //로그아웃 처리용 포스트 매핑
    @PostMapping("/outpro")
    public String logout(HttpSession session, HttpServletRequest request) {

        //로그아웃 클릭 시 저장 된 세션 삭제
        session.removeAttribute("uid");
        session.removeAttribute("auth");


        return "redirect:/";
    }

    //게시판 클릭 시 localhost:8080/home/board로 이동
    @GetMapping("/board")
    public String board(HttpServletRequest request) {

        //결과 값 반환용 변수
        String result = "";

        try {
            //게시판 진입 시 세션 검사
            HttpSession session = request.getSession(false);
            String userAuth = session.getAttribute("auth").toString();

            //요구 권한보다 낮으면 홈으로 redirect
            if (Integer.parseInt(userAuth) < 2) {

                System.out.println("권한이 없습니다.");
                result = "redirect:/home";

            }

            result = "/board/list";

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return result;
        }
    }

    @GetMapping("/userlist")
    public String userlist(HttpServletRequest request){

        //결과 값 반환용 변수
        String result = "";

        try{

            //사원조회 탭 진입 시 세션 검사
            HttpSession session = request.getSession(false);
            String userAuth = session.getAttribute("auth").toString();

            //요구 권한이 낮으면 홈으로 redirect
            if(Integer.parseInt(userAuth) < 2){


                result = "redirect:/home";

            }
            result = "userlist";

        }catch(Exception e){
            System.out.println(e);
        }finally {
            return result;
        }
    }


}
