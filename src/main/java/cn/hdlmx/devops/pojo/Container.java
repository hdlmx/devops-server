package cn.hdlmx.devops.pojo;

/**
 * 容器
 *
 * @author 韩东
 * @version 1.0
 * @date 2020/4/15 0:31
 */
public class Container extends io.fabric8.kubernetes.api.model.Container {
    /**
     * 镜像
     */
    private ImageRepository image;

    public Container() {
    }

    public Container(ImageRepository image) {
        this.image = image;
    }


    public void setImage(ImageRepository image) {
        this.image = image;
    }
}
