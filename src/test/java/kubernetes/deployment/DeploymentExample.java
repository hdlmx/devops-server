package kubernetes.deployment;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
/*import io.fabric8.kubernetes.client.Config;*/
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.*;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.Config;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeploymentExample {
    @Test
    public void createDeployment() {
       /* Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient();
        NodeList nodeList = client.nodes().list();
        for (Node node : nodeList.getItems()) {
            System.out.println(node);
            *//*System.out.println(node.getMetadata().getCreationTimestamp());
            System.out.println(node.getStatus().getImages());*//*
        }*/
    }

    @Test
    public void v2() throws IOException, ApiException {
        String fileName = this.getClass().getClassLoader().getResource("config").getPath();
        ApiClient apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(fileName))).build();
        Configuration.setDefaultApiClient(apiClient);
        CoreV1Api api = new CoreV1Api();
        V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    @Test
    public void v3() throws ApiException, IOException {
        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();
        V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null);
        V1NodeList nodeList = api.listNode(null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
        for (V1Node node : nodeList.getItems()) {
            System.out.println(node.getMetadata().getName());
            System.out.println(node.getStatus().getAddresses());
        }
    }

    public void deployment() {
        V1Secret v1Secret = new V1Secret();
        /*v1Secret.setMetadata();*/
        V1Deployment deployment = new V1Deployment();
        V1DeploymentSpec v1DeploymentSpec = new V1DeploymentSpec();
        V1PodTemplate v1PodTemplate = new V1PodTemplate();
        V1PodTemplateSpec v1PodTemplateSpec = new V1PodTemplateSpec();
        V1PodSpec v1PodSpec = new V1PodSpec();
        V1Container v1Container = new V1Container();
        v1Container.setImage("hub.devops.com/spring-boot/main-");
        List<V1Container> list = new ArrayList<>();
        list.add(v1Container);
        v1PodSpec.setContainers(list);
        v1PodTemplateSpec.setSpec(v1PodSpec);
        v1PodTemplate.setTemplate(v1PodTemplateSpec);
        deployment.setSpec(v1DeploymentSpec);
    }

    public void newNamespace() {
       /* Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient();*/
    }

}
