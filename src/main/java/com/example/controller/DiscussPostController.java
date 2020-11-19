package com.example.controller;

import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gx
 * @since 2020-11-05
 */
@RestController
@RequestMapping("/discussPost")
public class DiscussPostController {
    @Autowired
    MailService mailService;

    @GetMapping("/email")
    public Boolean send(){
        mailService.sendSimpleEmail("测试","测试的内容","1130045113@qq.com");
        return true;
    }

    @GetMapping("/hello")
    public String hello(){
        System.out.println("dataSource----");
        return "hello springboot ";
    }





}
