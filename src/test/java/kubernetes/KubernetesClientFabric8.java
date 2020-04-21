package kubernetes;

import constraint.KubernetesConstraint;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.apps.*;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.Test;

import java.util.*;

/**
 * @author 韩东
 * @version 1.0
 * @date 2020/2/7 20:02
 */
public class KubernetesClientFabric8 {
    private Config config = new ConfigBuilder().build();

    public void newNamespace() {
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient();
        Namespace namespace = new Namespace();
        namespace.setApiVersion("v1");
        namespace.setKind("Namespace");
        ObjectMeta metaData = new ObjectMeta();
        Map<String, String> lables = new HashMap<>();
        lables.put("name", "springboot-app");
        metaData.setLabels(lables);
        metaData.setName("springboot-app-namespace");
        namespace.setMetadata(metaData);
    }

    @Test
    public void newNamespaceV2() {
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        Namespace ns = new NamespaceBuilder().withNewMetadata().withName("springboot-app-namespace").addToLabels("name", "springbooot-app").endMetadata().build();
        client.namespaces().createOrReplace(ns);
    }

    @Test
    public void newPod() {

        Secret secret = new Secret();
        List<Secret> secretList = new ArrayList<>();
        secretList.add(secret);
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("username", "handong");
        dataMap.put("password", "hdlmx522104HB");
        dataMap.put(" docker-registry", "hub.devops.com");
        secret.setData(dataMap);
        Pod pod1 = new Pod();
        ObjectMeta meta = new ObjectMeta();
        meta.setName("springboot-app-main");
        meta.setNamespace("springboot-app-namespace");
        Map<String, String> labels = new HashMap<>();
        labels.put("name", "springboot-app-main-label");
        meta.setLabels(labels);
        pod1.setMetadata(meta);
        PodSpec podSpec = new PodSpec();
        List<LocalObjectReference> list = new ArrayList<>();
        list.add(new LocalObjectReference());
        //podSpec.setImagePullSecrets(secretList);
        Container container = new Container();
        container.setImage("hub.devops.com/helloworld/hello-app:v1");
        container.setName("springboot-app-main-container");
        container.setImagePullPolicy("Never");
        List<Container> containers = new ArrayList<>();
        containers.add(container);
        podSpec.setContainers(containers);
        pod1.setSpec(podSpec);
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        client.pods().create(pod1);
        //Pod pod = new PodBuilder().withApiVersion("v1").withNewMetadata().withName("springboot-app-main").endMetadata().build();

    }

    public void newReplicaSet() {
        ReplicaSet replicaSet = new ReplicaSet();
        replicaSet.getMetadata();
        ReplicaSetSpec replicaSetSpec = new ReplicaSetSpec();
        replicaSetSpec.setReplicas(2);
        LabelSelector labelSelector = new LabelSelector();
        labelSelector.setAdditionalProperty("name", "springboot-app-main-app");
        replicaSetSpec.setSelector(labelSelector);
        replicaSet.setSpec(replicaSetSpec);
    }

    @Test
    public void newPodV2() {
        List<LocalObjectReference> secrets = newSecrets();
        Pod pod1 = new Pod();
        ObjectMeta meta = new ObjectMeta();
        meta.setName("springboot-app-main");
        meta.setNamespace("springboot-app-namespace");
        Map<String, String> labels = new HashMap<>();
        labels.put("name", "springboot-app-main-label");
        meta.setLabels(labels);
        pod1.setMetadata(meta);
        PodSpec podSpec = new PodSpec();
        podSpec.setImagePullSecrets(secrets);
        List<LocalObjectReference> list = new ArrayList<>();
        list.add(new LocalObjectReference());
        Container container = new Container();
        container.setImage("hub.devops.com/helloworld/hello-app:v1");
        container.setName("springboot-app-main-container");
        container.setImagePullPolicy("Always");
        List<Container> containers = new ArrayList<>();
        containers.add(container);
        podSpec.setContainers(containers);
        pod1.setSpec(podSpec);
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        client.pods().create(pod1);
    }

    public List<LocalObjectReference> newSecrets() {
        List<LocalObjectReference> secrets = new ArrayList<>();
        LocalObjectReference secret = new LocalObjectReference();
        secret.setAdditionalProperty("docker-registry", "devops-images-hub");
        secret.setAdditionalProperty("docker-server", "hub.devops.com");
        secret.setAdditionalProperty("docker-username", "handong");
        secret.setAdditionalProperty("docker-password", "hdlmx522104HB");
        secret.setName("hub-devops");
        secrets.add(secret);
        return secrets;
    }

    @Test
    public void newDeployment() {
        /**创建kubernetes客户端*/
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        /**创建Deployment资源控制器对象*/
        Deployment deployment = new DeploymentBuilder().build();
        deployment.setKind(KubernetesConstraint.KUBERNETES_DEPLOYMENT);
        /**创建Deployment Metadata对象并设置属性*/
        ObjectMeta deploymentMeta = new ObjectMeta();
        deploymentMeta.setNamespace("springboot-app-namespace");
        deploymentMeta.setName("springboot-app-deployment");
        Map<String, String> labels = new HashMap<>();
        labels.put("app", "helloWorld");
        deploymentMeta.setLabels(labels);
        deployment.setMetadata(deploymentMeta);
        DeploymentSpec spec = new DeploymentSpec();
        /*设置副本数*/
        spec.setReplicas(4);
        LabelSelector labelSelector = new LabelSelector();
        /**
         * 目标pod的标签选择器*/
        Map<String, String> targetPodLabels = new HashMap<>();
        targetPodLabels.put("app", "helloWorld");
        labelSelector.setMatchLabels(targetPodLabels);
        spec.setSelector(labelSelector);
        PodTemplateSpec podTemplateSpec = newPodTemplate();
        spec.setTemplate(podTemplateSpec);
        deployment.setSpec(spec);
        client.apps().deployments().create(deployment);

    }

    public void updateDeployment() {

    }

    @Test
    public void scale() {
        KubernetesClient client = new DefaultKubernetesClient(config);
        //client.apps().deployments().inNamespace("springboot-app-namespace").withName("springboot-app-deployment").scale(4, false);
        boolean isReady = client.apps().deployments().inNamespace("springboot-app-namespace").withName("springboot-app-deployment").isReady();
        System.out.println(isReady);
    }

    public PodTemplateSpec newPodTemplate() {
        PodTemplateSpec podTemplateSpec = new PodTemplateSpec();
        ObjectMeta podMeta = new ObjectMeta();
        Map<String, String> labels = new HashMap<>();
        labels.put("app", "helloWorld");
        podMeta.setLabels(labels);
        PodSpec podSpec = new PodSpec();
        List<LocalObjectReference> secrets = newSecrets();
        podSpec.setImagePullSecrets(secrets);
        Container container = new Container();
        container.setImage("hub.devops.com/helloworld/hello-app:v1");
        container.setName("springboot-app-main-container");
        container.setImagePullPolicy("Always");
        List<Container> containers = new ArrayList<>();
        containers.add(container);
        podSpec.setContainers(containers);
        podTemplateSpec.setMetadata(podMeta);
        podTemplateSpec.setSpec(podSpec);
        return podTemplateSpec;
    }

    @Test
    public void newService() {
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        Service service = new Service();
        /**设置service资源类型名*/
        service.setKind(KubernetesConstraint.KUBERNETES_SERVICE);
        /**新建并设置Service meta对象*/
        ObjectMeta serviceMeta = new ObjectMeta();
        serviceMeta.setName("helloworld-service");
        serviceMeta.setNamespace("springboot-app-namespace");
        serviceMeta.setLabels(Collections.singletonMap("name", "helloService"));
        /**新建并设置Service spec对象*/
        ServiceSpec serviceSpec = new ServiceSpec();
        serviceSpec.setType("NodePort");
        serviceSpec.setSelector(Collections.singletonMap("app", "helloWorld"));
        ServicePort port = new ServicePort("http", 30715, 80, KubernetesConstraint.PROTOCOL_TCP, new IntOrString(80));
        List<ServicePort> list = new ArrayList<>();
        list.add(port);
        serviceSpec.setPorts(list);
        service.setSpec(serviceSpec);
        service.setMetadata(serviceMeta);
        client.services().create(service);
    }

    public void newPodTempl() {
        PodSpec podSpec=new PodSpec();
        Container container=new Container();
        ResourceRequirements resourceRequirements=new ResourceRequirements();
        resourceRequirements.setRequests();
        Map<String,Object> requiresConfig=new HashMap<>();
        requiresConfig.put("cup",'200m');
        LimitRange limitRange=new LimitRange();
        limitRange.setSpec();
        LimitRangeSpec rangeSpec=new LimitRangeSpec();
        rangeSpec.
        rangeSpec.setLimits();
        LimitRangeItem limitRangeItem=new LimitRangeItem();
        limitRangeItem.s
        container.setResources();
        podSpec.setContainers();
        Config config = new ConfigBuilder().build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        ResourceRequirements
        client.limitRanges().create(limitRange);
        client.resourceQuotas().create()

    }

}
