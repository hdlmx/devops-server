package cn.hdlmx.devops.controller;

import cn.hdlmx.devops.pojo.AppDeployment;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Node;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DeploymentController {
    @Value("${kubernetes.configPath}")
    private String KubernetesConfigFilePath;

    @RequestMapping(value = "/deploy", method = RequestMethod.GET)
    public String configPath(@PathVariable("id") String id) {
        return this.KubernetesConfigFilePath + id;
    }

    @RequestMapping("/deploy/s")
    public List<String> createDeployment() throws ApiException {
        List<String> result = new ArrayList<>();
        try {
            String fileName = this.getClass().getClassLoader().getResource("config").getPath();
            ApiClient apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(fileName))).build();
            Configuration.setDefaultApiClient(apiClient);
            CoreV1Api api = new CoreV1Api();
            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null);
            V1NodeList nodeList = api.listNode(null, null, null, null, null, null, null, null);

            for (V1Pod item : list.getItems()) {
                result.add(item.getMetadata().getName());
            }
            for (V1Node node : nodeList.getItems()) {
                result.add(node.getMetadata().getName());
            }
        } catch (ApiException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
