package Kim.OwnHub.git;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class OwnGit {

    public void createNewRepo(String dirName) throws IOException, GitAPIException {

        // prepare a new folder
        File localPath = File.createTempFile("TestGitRepository", "",new File("/Users/laykis/Desktop/gitTest"));
        if(!localPath.delete()) {
            throw new IOException("Could not delete temporary file " + localPath);
        }
        FileUtils.deleteDirectory(localPath);

        File filePath = new File("/Users/laykis/Desktop/gitTest/"+dirName);
        filePath.mkdir();
        // create the directory
        try (Git git = Git.init().setDirectory(filePath).call()) {
            System.out.println("Having repository: " + git.getRepository().getDirectory());
        }catch(GitAPIException e){
            e.printStackTrace();
        }

    }

    public Git openRepo(String repoName) throws IOException {

        Git git = Git.open(new File("/Users/laykis/Desktop/gitTest/"+repoName));

        System.out.println(git.getRepository().getDirectory());

        return git;

    }

}
