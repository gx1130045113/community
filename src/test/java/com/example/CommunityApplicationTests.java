package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.domain.DiscussPost;
import com.example.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    private DiscussPostService discussPostService;

    @Test
    void contextLoads() {
/*        List<DiscussPost> list=discussPostService.selectDiscussPosts(0,0,10);
        for (DiscussPost post:list){
            System.out.println(post);
        }*/

        LambdaQueryWrapper<DiscussPost> queryWrapper=new LambdaQueryWrapper();
        int a=0;
        queryWrapper.eq(a!=0,DiscussPost::getUserId, a);
        System.out.println(discussPostService.count(queryWrapper));
    }

}
