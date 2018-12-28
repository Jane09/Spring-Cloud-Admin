package com.github.wxiaoqi.security.auth.feign;

import com.github.wxiaoqi.security.api.vo.user.UserInfo;
import com.github.wxiaoqi.security.auth.configuration.FeignConfiguration;
import com.github.wxiaoqi.security.auth.util.user.JwtAuthenticationRequest;
import com.github.wxiaoqi.security.common.constant.FeignApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-21 8:11
 */
@FeignClient(value = FeignApi.ACE_ADMIN,configuration = FeignConfiguration.class)
public interface IUserService {
  @RequestMapping(value = "/api/user/validate", method = RequestMethod.POST)
  public UserInfo validate(@RequestBody JwtAuthenticationRequest authenticationRequest);
}
