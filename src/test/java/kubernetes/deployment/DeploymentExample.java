package kubernetes.deployment;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.apis.CoreApi;
import io.kubernetes.client.proto.V1Apps;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DeploymentExample {
    @Test
    public void createDeployment() {
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient();
        NodeList nodeList = client.nodes().list();


        for (Node node : nodeList.getItems()) {
            System.out.println(node.getMetadata().getCreationTimestamp());
            System.out.println(node.getStatus().getImages());
        }
    }

    public void v2() throws IOException {
        String fileName = this.getClass().getClassLoader().getResource("config").getPath();
        ApiClient apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(fileName))).build();


    }

}
