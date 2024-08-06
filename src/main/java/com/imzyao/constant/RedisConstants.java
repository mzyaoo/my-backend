package com.imzyao.constant;

/**
 * 用户常量信息
 */
public class RedisConstants {

    private static final String LOGIN_KEY_BEGIN = "login:";


    /**
     * 获取用户登录的key
     *
     * @param key
     * @return
     */
    public static String getLoginKey(String key) {
        return LOGIN_KEY_BEGIN + key;
    }

}
