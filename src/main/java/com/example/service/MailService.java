package com.example.service;

/**
 * @ClassName MailService
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/6
 * @Version V1.0
 **/
public interface MailService {

     void sendSimpleEmail(String subject,String text,String to);

     void sendHtmlMail(String subject,String text,String to);

     void sendAttachMail(String subject,String text,String to,String filePath,String fileName,String fileType);


}
