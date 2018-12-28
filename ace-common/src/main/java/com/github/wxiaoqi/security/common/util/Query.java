package com.github.wxiaoqi.security.common.util;


import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
@Getter
@Setter
public class Query extends LinkedHashMap<String, Object> {
    private static final String PAGE = "page";
    private static final String LIMIT = "limit";

	private static final long serialVersionUID = 1L;
    private int page = 1;
    private int limit = 10;

    public Query(Map<String, Object> params){
        this.putAll(params);
        if(params.get(PAGE)!=null) {
            this.page = Integer.parseInt(params.get(PAGE).toString());
        }
        if(params.get(LIMIT)!=null) {
            this.limit = Integer.parseInt(params.get(LIMIT).toString());
        }
        this.remove(PAGE);
        this.remove(LIMIT);
    }
}
