package com.github.wxiaoqi.security.common.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-14 22:40
 */
@Getter
@Setter
public class TableResultResponse<T> extends BaseResponse {

    TableData<T> data;

    public TableResultResponse(long total, List<T> rows) {
        this.data = new TableData<>(total, rows);
    }

    public TableResultResponse() {
        this.data = new TableData<T>();
    }

    TableResultResponse<T> total(int total) {
        this.data.setTotal(total);
        return this;
    }

    TableResultResponse<T> rows(List<T> rows) {
        this.data.setRows(rows);
        return this;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class TableData<T> {
        long total;
        List<T> rows;
    }
}
