package Kim.OwnHub.controller;

import Kim.OwnHub.DTO.UserDTO;
import Kim.OwnHub.git.OwnGit;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController extends OwnGit {


    @GetMapping("/api/hello")
    public String helloworld() {

        return "Hello world";
    }

    @GetMapping("/createRepo")
    public String CreateNewRepo() throws GitAPIException, IOException {
        createNewRepo("testdir");

        return "sucsess";
    }

    @GetMapping("/openRepo")
    public String openRepo() throws GitAPIException, IOException{

        Git ogit = openRepo("testdir");
        System.out.println(ogit.log());

        return "openSucsess";
    }



}





