package cn.qb.forum.sky.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class SkyUtil {

    /**
     * 激活成功
     */
    public static final Integer ACTIVATION_SUCCESS = 1;

    /**
     * 重复激活
     */
    public static final Integer ACTIVATION_REPEAT = 2;

    /**
     * 激活失败
     */
    public static final Integer ACTIVATION_FAILURE = 3;

    /**
     * 获取随机的字符串
     * @return 返回随机字符串
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").substring(6,12);
    }

    /**
     * 获取MD5
     * @param key 传入的字符串
     * @return 计算后的加密字符串
     */
    public static String getMD5(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
