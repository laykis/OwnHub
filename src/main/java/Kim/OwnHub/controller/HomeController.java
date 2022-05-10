package Kim.OwnHub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("/outpro")
    public String logout(HttpSession session, HttpServletRequest request) {
        System.out.println(request.getParameter("uid"));
        System.out.println(request.getParameter("auth"));
        session.removeAttribute("uid");
        session.removeAttribute("auth");


        return "redirect:/";
    }

    @GetMapping("/board")
    public String board(HttpServletRequest request) {

        String result = "";

        try {
            HttpSession session = request.getSession(false);
            String userAuth = session.getAttribute("auth").toString();

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

        String result = "";

        try{

            HttpSession session = request.getSession(false);
            String userAuth = session.getAttribute("auth").toString();

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
