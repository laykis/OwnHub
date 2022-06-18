package Kim.OwnHub.controller;

import Kim.OwnHub.git.Jgit;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class HelloController {


    @GetMapping("/api/hello")
    public String helloworld(){

        return "Hello world";
    }

    private File dir = new File("/Users/laykis/Desktop/gitTest");

    @GetMapping("")
    public void init(){
        try{
            Jgit.init(dir);
            Git.open(dir).checkout();
            Repository repository = Git.cloneRepository().getRepository();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
