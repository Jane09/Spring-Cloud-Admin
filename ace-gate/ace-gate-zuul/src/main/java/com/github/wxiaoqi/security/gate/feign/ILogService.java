package com.github.wxiaoqi.security.gate.feign;

import com.github.wxiaoqi.security.api.vo.log.LogInfo;
import com.github.wxiaoqi.security.common.constant.FeignApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 15:16
 */
@FeignClient(FeignApi.ACE_ADMIN)
public interface ILogService {
  @RequestMapping(value="/api/log/save",method = RequestMethod.POST)
  public void saveLog(LogInfo info);
}
