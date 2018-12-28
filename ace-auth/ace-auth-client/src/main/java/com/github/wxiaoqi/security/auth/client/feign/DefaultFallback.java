package com.github.wxiaoqi.security.auth.client.feign;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/28 14:32
 */
@Component
public class DefaultFallback implements ServiceAuthFeign {
    @Override
    public ObjectRestResponse<List<String>> getAllowedClient(String serviceId, String secret) {
        return new ObjectRestResponse<>();
    }

    @Override
    public ObjectRestResponse getAccessToken(String clientId, String secret) {
        return new ObjectRestResponse<>();
    }

    @Override
    public ObjectRestResponse<byte[]> getServicePublicKey(String clientId, String secret) {
        return new ObjectRestResponse<>();
    }

    @Override
    public ObjectRestResponse<byte[]> getUserPublicKey(String clientId, String secret) {
        return new ObjectRestResponse<>();
    }
}
