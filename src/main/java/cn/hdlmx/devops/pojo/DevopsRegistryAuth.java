package cn.hdlmx.devops.pojo;

import com.spotify.docker.client.messages.RegistryAuth;

import javax.annotation.Nullable;

/**
 * @author 韩东
 * @version 1.0
 * @date 2019/12/17 15:24
 */
public class DevopsRegistryAuth extends RegistryAuth {
    @Nullable
    @Override
    public String username() {
        return null;
    }

    @Nullable
    @Override
    public String password() {
        return null;
    }

    @Nullable
    @Override
    public String email() {
        return null;
    }

    @Nullable
    @Override
    public String serverAddress() {
        return null;
    }

    @Nullable
    @Override
    public String identityToken() {
        return null;
    }

    @Override
    public Builder toBuilder() {
        return null;
    }
}
