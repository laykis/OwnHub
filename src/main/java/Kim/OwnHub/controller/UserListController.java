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

    public List<UserInfo> searchUserByName(String username){

        List<UserInfo> relist = new ArrayList<>();

        try{

            relist = userService.getAllUserByUsername(username);

        }catch(Exception e){
            System.out.println(e);
        }

        return relist;
    }


    public List<UserInfo> searchUserByTeam(String team){

        List<UserInfo> relist = new ArrayList<>();

        try{

            relist = userService.getAllUserByUserTeam(team);

        }catch (Exception e){
            System.out.println(e);
        }

        return relist;
    }
}
