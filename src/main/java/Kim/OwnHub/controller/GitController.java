package Kim.OwnHub.controller;

import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.git.OwnGit;
import Kim.OwnHub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GitController extends OwnGit {

    private UserRepository userRepository;


    @GetMapping("/createRepo")
    public String CreateNewRepo(HttpServletRequest request) throws GitAPIException, IOException {

        HttpSession session = request.getSession();
        Long uid = (Long) session.getAttribute("uid");

        Optional<UserInfo> userInfo = userRepository.findById(uid);
        UserInfo user = userInfo.orElseThrow(NoSuchElementException::new);

        createNewRepo(user.getUserId(), "testdir");

        return "sucsess";
    }

    @GetMapping("/openRepo")
    public String openRepo(HttpServletRequest request) throws GitAPIException, IOException{


        HttpSession session = request.getSession();
        Long uid = (Long) session.getAttribute("uid");

        Optional<UserInfo> userInfo = userRepository.findById(uid);
        UserInfo user = userInfo.orElseThrow(NoSuchElementException::new);


        Git ogit = openRepo(user.getUserId(), "testdir");
        System.out.println(ogit.log());

        return "openSucsess";
    }



}





