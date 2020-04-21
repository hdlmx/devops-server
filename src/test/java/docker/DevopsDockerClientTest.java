package docker;

import cn.hdlmx.devops.pojo.Application;
import cn.hdlmx.devops.pojo.BuildHistory;
import cn.hdlmx.devops.util.DevopsDockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import org.junit.Test;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/13 10:43
 */
public class DevopsDockerClientTest {
    @Test
    public void clientTest() throws DockerCertificateException, DockerException, InterruptedException {
        BuildHistory history = new BuildHistory();
        Application application = new Application();
        application.setMark("springbootapp");
        DevopsDockerClient.makeDockerfile(application);


        //DevopsDockerClient.makeDockerImageByDockerfile();

    }

    @Test
    public void pushTest() {
        BuildHistory history = new BuildHistory();
        Application application = new Application();
        application.setMark("springbootapp");
        application.setProjectNamespace("helloworld");
        history.setTag("hub.devops.com/helloworld/helloworld:");
        DevopsDockerClient.pushImage(history, application);
    }
}
