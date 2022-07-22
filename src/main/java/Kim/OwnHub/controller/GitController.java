package Kim.OwnHub.controller;

import Kim.OwnHub.entity.UserInfo;
import Kim.OwnHub.git.Controller;
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
public class GitController extends Controller {

    private final UserRepository userRepository;
    private final OwnGit ownGit;

    @GetMapping("/createRepo")
    public String CreateNewRepo(HttpServletRequest request, String repoName) throws GitAPIException, IOException {

        String uid = getSession(request, "uid");

        Optional<UserInfo> userInfo = userRepository.findById(Long.parseLong(uid));
        UserInfo user = userInfo.orElseThrow(NoSuchElementException::new);


        ownGit.createNewRepo(user.getUserId(), repoName);
//        createNewRepo("laykis", "laytest");

        return repoName + "Repository 생성 성공!";
    }

    @GetMapping("/openRepo")
    public String openRepo(HttpServletRequest request) throws GitAPIException, IOException{


        String uid = getSession(request, "uid");

        Optional<UserInfo> userInfo = userRepository.findById(Long.parseLong(uid));
        UserInfo user = userInfo.orElseThrow(NoSuchElementException::new);


        Git ogit = ownGit.openRepo(user.getUserId(), "testdir");
        System.out.println(ogit.log());

        return "openSucsess";
    }



}





