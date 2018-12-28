package com.github.wxiaoqi.security.auth.bean;


import com.github.wxiaoqi.security.auth.common.util.jwt.IJWTInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ace on 2017/9/10.
 */
@Getter
@Setter
public class ClientInfo implements IJWTInfo {
    String clientId;
    String name;
    String id;

    public ClientInfo(String clientId, String name, String id) {
        this.clientId = clientId;
        this.name = name;
        this.id = id;
    }

    @Override
    public String getUniqueName() {
        return clientId;
    }
}
