package com.example.util;

/**
 * @ClassName RedisKeyUtil
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/6
 * @Version V1.0
 **/
public class RedisKeyUtil {
    private static final String SPLIT=":";
    private static final String PREFIX_ENTITY_LIKE="like:entity";

    //某个实体的赞
    public static String getEntityLikeKey(int entityType,int entityId){
        return PREFIX_ENTITY_LIKE+SPLIT+entityType+SPLIT+entityId;
    }
}
