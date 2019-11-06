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

public class DockerClientSample {

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
    public void build() throws DockerCertificateException, InterruptedException, DockerException, IOException {
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        File dockerFile = new File("D:" + File.separator + "mastersDegreeWorkSpace" + File.separator + "springboot-app");
        Path dockerFilePath = dockerFile.toPath();
        DockerClient.BuildParam buildParam = new DockerClient.BuildParam("t", "hub.devops.com/library/springboot-app:v2");
        String imagesId = dockerClient.build(dockerFilePath, buildParam);
        System.out.println(imagesId);
    }

    @Test
    public void push() throws DockerCertificateException, DockerException, InterruptedException {
        final DockerClient dockerClient = DefaultDockerClient.fromEnv().build();
        final RegistryAuth registryAuth = RegistryAuth.create("handong", "hdlmx522104HB", "hdlmxos@163.com", "hub.devops.com", null, "aGFuZG9uZzpoZGxteDUyMjEwNEhC");
        dockerClient.push("hub.devops.com/springboot-app/main-app:v1", registryAuth);
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
}
