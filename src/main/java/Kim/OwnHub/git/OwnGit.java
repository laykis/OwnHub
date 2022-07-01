package Kim.OwnHub.git;

import Kim.OwnHub.DTO.UserDTO;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class OwnGit {

    private static String userName = "";
    private static String userEmail = "";

    public void createNewRepo(String userName, String dirName) throws IOException, GitAPIException {

        // prepare a new folder
        File localPath = File.createTempFile("TestGitRepository", "",new File("/Users/laykis/Desktop/gitTest"));
        if(!localPath.delete()) {
            throw new IOException("Could not delete temporary file " + localPath);
        }
        FileUtils.deleteDirectory(localPath);

        File filePath = new File("/Users/laykis/Desktop/gitTest/" + userName + "/" + dirName);
        filePath.mkdir();
        // create the directory
        try (Git git = Git.init().setDirectory(filePath).call()) {
            System.out.println("Having repository: " + git.getRepository().getDirectory());
        }catch(GitAPIException e){
            e.printStackTrace();
        }

    }

    public Git openRepo(String userName, String repoName) throws IOException {

        Git git = Git.open(new File("/Users/laykis/Desktop/gitTest/" + userName + "/"+repoName));

        System.out.println(git.getRepository().getDirectory());

        return git;

    }

    public static void add(Git git, String filePattern) throws Exception{
        git.add().addFilepattern(filePattern).call();
    }

    public static void commit(Git git, String msg) throws Exception{

        git.commit()
                .setAuthor(userName, userEmail)
                .setMessage(msg)
                .call();
    }


}
