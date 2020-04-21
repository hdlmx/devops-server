package cn.hdlmx.devops.pojo;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/17 14:37
 */
public class BuildHistory {
    private String id;
    private String imageId;
    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
