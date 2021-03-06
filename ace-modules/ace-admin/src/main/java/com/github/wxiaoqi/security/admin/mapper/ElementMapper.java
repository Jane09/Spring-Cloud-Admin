package com.github.wxiaoqi.security.admin.mapper;

import com.github.wxiaoqi.security.admin.entity.Element;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ElementMapper extends Mapper<Element> {

    List<Element> selectAuthorityElementByUserId(@Param("userId") String userId);

    List<Element> selectAuthorityMenuElementByUserId(@Param("userId") String userId, @Param("menuId") String menuId);

    List<Element> selectAuthorityElementByClientId(@Param("clientId") String clientId);

    List<Element> selectAllElementPermissions();
}