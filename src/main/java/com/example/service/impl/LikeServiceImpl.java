package com.example.service.impl;

import com.example.service.LikeService;
import com.example.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName LikeServiceiMPL
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/6
 * @Version V1.0
 **/
@Service
public class LikeServiceImpl  implements LikeService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void like(int userId, int entityType, int entityId) {

        String entityLikeKey= RedisKeyUtil.getEntityLikeKey(entityType,entityId);

        Boolean member = redisTemplate.opsForSet().isMember(entityLikeKey, userId);
        if (member){
            redisTemplate.opsForSet().remove(entityLikeKey, userId);
        }else {
            redisTemplate.opsForSet().add(entityLikeKey, userId);
        }

    }

    @Override
    public Long findEntityLikeKey(int entityType, int entityId) {
        String entityLikeKey=RedisKeyUtil.getEntityLikeKey(entityType,entityId);
        return redisTemplate.opsForSet().size(entityLikeKey);
    }

    @Override
    public int findEntityLikeStatus(int userId, int entityType, int entityId) {
        String entityLikeKey=RedisKeyUtil.getEntityLikeKey(entityType,entityId);

        return redisTemplate.opsForSet().isMember(entityLikeKey,userId)?1:0;
    }

}
