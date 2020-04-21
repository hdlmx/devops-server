package cn.hdlmx.devops.util;

import cn.hdlmx.devops.pojo.Application;
import cn.hdlmx.devops.pojo.BuildHistory;
import cn.hdlmx.devops.pojo.ImageRepository;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.ProgressHandler;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ProgressMessage;
import com.spotify.docker.client.messages.RegistryAuth;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/12 17:13
 */
public class DevopsDockerClient {
    final static String DOCKER_FILE_BASE_DIRECTORY = "D:\\mastersDegreeWorkSpace\\build-artifacts\\";
    final static String DOCKER_HUB_URL = "hub.devops.com";

    public static String makeDockerfile(Application app) {
        final DefaultDockerClient docker;
        Path path = Paths.get(DOCKER_FILE_BASE_DIRECTORY + File.separatorChar + app.getProjectNamespace() + File.separatorChar + app.getMark());
        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
        try {
            docker = DefaultDockerClient.fromEnv().connectionPoolSize(20).build();
            docker.build(path, "hub.devops.com/helloworld/helloworld:2019-12-17-new", "Dockerfile", new ProgressHandler() {
                @Override
                public void progress(ProgressMessage message) throws DockerException {
                    final String imageId = message.buildImageId();
                    final String messageString = message.progress();
                    System.out.println("构建过程：" + messageString);
                    if (imageId != null) {
                        imageIdFromMessage.set(imageId);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (DockerCertificateException e) {
            System.out.println("docker服务端连接失败！");
            e.printStackTrace();
        } catch (DockerException e) {
            e.printStackTrace();
        }
        return imageIdFromMessage.get();
    }

    public static boolean pushImage(BuildHistory history, Application application) {
        final DefaultDockerClient docker;
        try {
            docker = DefaultDockerClient.fromEnv().connectionPoolSize(20).build();
            ImageRepository imageRepository = application.getImageRepository();
            final RegistryAuth registryAuth = RegistryAuth.builder()
                    .email(imageRepository.getEmail()).username(imageRepository.getUsername()).password(imageRepository.getPassword()).serverAddress("hub.devops.com")
                    .build();
            docker.push(history.getTag(), registryAuth);
        } catch (DockerCertificateException e) {
            System.out.println("docker服务端连接失败，请检查网络！");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("push失败1");
            e.printStackTrace();
        } catch (DockerException e) {
            e.printStackTrace();
        }
        return true;
    }
}
