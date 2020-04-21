package dockerclient;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.RegistryAuth;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class DevopsDockerClientSample {
    public static final String HarborServerAddress = "hub.devops.com";

    @Test
    public void pull() {
        try {
            DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
            /*dockerClient.pull("hub.devops.com/library/nginx:v1");*/
            List<Image> images = dockerClient.listImages();
            for (Image image : images) {
                System.out.println(image.id());
                System.out.println(image.created());
                System.out.println(image.repoTags());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DockerException e) {
            e.printStackTrace();
        } catch (DockerCertificateException e) {
            e.printStackTrace();
        }
    }

    @Test
    public String build(String dockerFileDir, String tag) throws DockerCertificateException, InterruptedException, DockerException, IOException {
        /*读取DOCKER_HOST的环境变脸，创建docker客户端，并建立连接*/
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        /*读取Dockerfile所在的目录，创建Dockerfile对象*/
        File dockerFile = new File("D:" + File.separator + "mastersDegreeWorkSpace" + File.separator + "springboot-app");
        Path dockerFilePath = dockerFile.toPath();
        /*docker客户端发起build命令创建docker镜像，并给镜像打上tag*/
        DockerClient.BuildParam buildParam = new DockerClient.BuildParam("t", "hub.devops.com/springboot-app/main-app:v5");
        return dockerClient.build(dockerFilePath, buildParam);
    }

    /**
     * @param dockerFileDir
     * @param tag
     */
    public String buildImage(String dockerFileDir, String tag) throws Exception {
        /*读取DOCKER_HOST的环境变脸，创建docker客户端，并建立连接*/
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        /*读取Dockerfile所在的目录，创建Dockerfile对象*/
        File dockerFile = new File(dockerFileDir);
        Path dockerFilePath = dockerFile.toPath();
        /*docker客户端发起build命令创建docker镜像，并给镜像打上tag*/
        DockerClient.BuildParam buildParam = new DockerClient.BuildParam("t", tag);
        /*返回ImageId*/
        return dockerClient.build(dockerFilePath, buildParam);
    }

    @Test
    /**
     * */
    public void push(String username, String pw, String image) throws DockerCertificateException, DockerException, InterruptedException {
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        final RegistryAuth registryAuth = RegistryAuth.create("handong", "hdlmx522104HB", "hdlmxos@163.com", "hub.devops.com", null, "aGFuZG9uZzpoZGxteDUyMjEwNEhC");
        dockerClient.push("hub.devops.com/springboot-app/main-app:v5", registryAuth);
    }

    /**
     * @param username 镜像仓库用户名
     * @param pw       镜像仓库密码
     * @param image    需要推送的镜像
     */
    public void pushImage(String username, String pw, String image) throws Exception {
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        /**/
        final RegistryAuth registryAuth = RegistryAuth.create(username, pw, null, HarborServerAddress, null, null);
        dockerClient.push(image, registryAuth);
    }

    @Test
    public void push1() throws DockerCertificateException, DockerException, InterruptedException {
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        final RegistryAuth registryAuth = RegistryAuth.builder()
                .username("develop01")
                .password("hdlmx522104HB")
                .email("990489713@qq.com")
                .serverAddress("hub.devops.com").build();
        dockerClient.push("hub.devops.com/test/springboot-app:v1", registryAuth);
    }

    public void newNamespace() {

    }
}
