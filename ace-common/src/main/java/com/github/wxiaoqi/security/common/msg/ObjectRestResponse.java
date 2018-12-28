package com.github.wxiaoqi.security.common.msg;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ace on 2017/6/11.
 */
@Getter
@Setter
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel;

    public ObjectRestResponse rel(boolean rel) {
        this.setRel(rel);
        return this;
    }
    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

}
