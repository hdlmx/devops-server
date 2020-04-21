package cn.hdlmx.devops.util.git;

import cn.hdlmx.devops.emun.GitClone;
import cn.hdlmx.devops.pojo.GitRepository;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/11 17:30
 */
public class GitClient {
    public static GitClone cloneRepository(GitRepository gitRepository, String localPath) {
        /*GitRepository封装了git仓库的属性*/
        try {
            /*设置代码仓库的url*/
            CloneCommand cc = Git.cloneRepository().setURI(gitRepository.getUrl());
            /*传入仓库认证：用户名，密码*/
            cc.setCredentialsProvider(new UsernamePasswordCredentialsProvider(gitRepository.getUsername(), gitRepository.getPassword()));
            /*设置保存至本地的目录*/
            cc.setDirectory(new File(localPath)).call();
            return GitClone.SUCCESS;
        } catch (InvalidRemoteException e) {
            e.printStackTrace();
            return GitClone.REPOSITORYNOTFOUND;
        } catch (TransportException e) {
            e.printStackTrace();
            return GitClone.CREDENTIALFAILED;
        } catch (GitAPIException e) {
            e.printStackTrace();
            return GitClone.FAILED;
        }
    }

    public static boolean cloneGitRepository(GitRepository gitRepository, String localPath) {
        try {
            /*设置代码仓库的url*/
            CloneCommand cc = Git.cloneRepository().setURI(gitRepository.getUrl());
            /*传入仓库认证：用户名，密码*/
            cc.setCredentialsProvider(
                    new UsernamePasswordCredentialsProvider(gitRepository.getUsername(),
                    gitRepository.getPassword()));
            /*设置保存至本地的目录*/
            cc.setDirectory(new File(localPath)).call();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
