package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.config.Page;
import com.example.domain.DiscussPost;
import com.example.domain.User;
import com.example.service.DiscussPostService;
import com.example.service.MailService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HomeController
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/5
 * @Version V1.0
 **/
@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        LambdaQueryWrapper<DiscussPost> queryWrapper=new LambdaQueryWrapper();
        int b=0;
        queryWrapper.eq(b!=0,DiscussPost::getUserId, b);
        page.setRows(discussPostService.count(queryWrapper));
        page.setPath("/index");
        List<DiscussPost> list=discussPostService.selectDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if (list !=null){
            for (DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.getById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        return "/index";
    }



}
