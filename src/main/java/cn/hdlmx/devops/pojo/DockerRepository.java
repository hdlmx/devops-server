package cn.hdlmx.devops.pojo;

/**
 * @author 韩东
 * @version 1.0
 * @date 2020/2/13 16:31
 */
public class DockerRepository extends Repository {
    private String registry;
    private String serverAddress;
    private String repositoryName;

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }
}
