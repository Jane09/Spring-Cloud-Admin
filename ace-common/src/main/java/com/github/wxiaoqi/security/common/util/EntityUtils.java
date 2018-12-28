package com.github.wxiaoqi.security.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;



/**
 * 实体类相关工具类 
 * 解决问题： 1、快速对实体的常驻字段，如：crtUser、crtHost、updUser等值快速注入
 * 
 * @author Ace
 * @version 1.0
 * @date 2016年4月18日
 * @since 1.7
 */
public class EntityUtils {

	private static final String[] CREATE_FIELDS = {"crtName","crtUser","crtHost","crtTime"};
	private static final String[] UPDATE_FIELDS = {"updName","updUser","updHost","updTime"};

	/**
	 * 快速将bean的crtUser、crtHost、crtTime、updUser、updHost、updTime附上相关值
	 * 
	 * @param entity 实体bean 
	 * @author 王浩彬
	 */
	public static <T> void setCreatAndUpdatInfo(T entity) {
		setUpdatedInfo(entity);
	}
	


	private static HttpServletRequest getRequest() {
		RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
		if(attributes instanceof ServletRequestAttributes) {
			return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		}
		return null;
	}

	/**
	 * 快速将bean的updUser、updHost、updTime附上相关值
	 * 
	 * @param entity 实体bean
	 * @author 王浩彬
	 */
	public static <T> void setUpdatedInfo(T entity){
		HttpServletRequest request = getRequest();
		String hostIp = "";
		String name = "";
		String id = "";
		if(request!=null) {
			hostIp = request.getHeader("userHost");
			name = request.getHeader("userName");
			if(StringUtils.isNotBlank(name)) {
				try {
					name = URLDecoder.decode(name,StandardCharsets.UTF_8.displayName());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			id = request.getHeader("userId");
		}

		// 默认属性
		Field field = ReflectionUtils.getAccessibleField(entity, "crtTime");
		Class dateClass = Date.class;
		// 默认值
		Object [] value = null;
		if(field!=null && field.getType().equals(dateClass)){
			value = new Object []{name,id,hostIp, LocalDateTime.now()};
		}
		// 填充默认属性值
		setDefaultValues(entity, CREATE_FIELDS, value);

		// 默认属性
		field = ReflectionUtils.getAccessibleField(entity, "updTime");
		value = null;
		if(field!=null && field.getType().equals(dateClass)){
			value = new Object []{ name,id,hostIp,LocalDateTime.now()};
		}
		// 填充默认属性值
		setDefaultValues(entity, UPDATE_FIELDS, value);
	}

	/**
	 * 依据对象的属性数组和值数组对对象的属性进行赋值
	 * 
	 * @param entity 对象
	 * @param fields 属性数组
	 * @param value 值数组
	 * @author 王浩彬
	 */
	private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
		for(int i=0;i<fields.length;i++){
			String field = fields[i];
			if(ReflectionUtils.hasField(entity, field)){
				ReflectionUtils.invokeSetter(entity, field, value[i]);
			}
		}
	}
	/**
	 * 根据主键属性，判断主键是否值为空
	 * 
	 * @param entity
	 * @param field
	 * @return 主键为空，则返回false；主键有值，返回true
	 * @author 王浩彬
	 * @date 2016年4月28日
	 */
	public static <T> boolean isPKNotNull(T entity,String field){
		if(!ReflectionUtils.hasField(entity, field)) {
			return false;
		}
		Object value = ReflectionUtils.getFieldValue(entity, field);
		return value!=null&&!"".equals(value);
	}
}
