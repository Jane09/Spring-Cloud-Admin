package com.github.wxiaoqi.security.common.context;

import com.github.wxiaoqi.security.common.constant.CommonConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tb
 */
public final class BaseContextHandler {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    private static String getValue(String key) {
        return returnObjectValue(get(key));
    }

    public static String getUserID(){
        return getValue(CommonConstants.CONTEXT_KEY_USER_ID);
    }

    public static String getUsername(){
        return getValue(CommonConstants.CONTEXT_KEY_USERNAME);
    }


    public static String getName(){
        return getValue(CommonConstants.CONTEXT_KEY_USER_NAME);
    }

    public static String getToken(){
        return getValue(CommonConstants.CONTEXT_KEY_USER_TOKEN);
    }
    public static void setToken(String token){set(CommonConstants.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setName(String name){set(CommonConstants.CONTEXT_KEY_USER_NAME,name);}

    public static void setUserID(String userID){
        set(CommonConstants.CONTEXT_KEY_USER_ID,userID);
    }

    public static void setUsername(String username){
        set(CommonConstants.CONTEXT_KEY_USERNAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:String.valueOf(value);
    }

    public static void remove(){
        threadLocal.remove();
    }

}
