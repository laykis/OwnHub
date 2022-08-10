package Kim.OwnHub.controller;

import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.repository.UserRepository;
import Kim.OwnHub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserListController {

    //의존성 주입(DI, Dependency Injection)
    private final UserService userService;


    @PostMapping("/member_list")
    public List<UserDTO> userList(String userName){
        List<UserDTO> userDTO = new ArrayList<>();
        System.out.println(userName);
        List<UserInfo> userInfo = userService.getAllUserByUsername(userName.trim());

        for(int i = 0; i < userInfo.size(); i++){
            userDTO.add(i, userInfo.get(i).convert(userInfo.get(i)));
        }
        System.out.println(userDTO.get(0).getUsername());
        return userDTO;
    }

}
