package com.example.service.impl;

import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName MailServiceImpl
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/11/6
 * @Version V1.0
 **/
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.host}")
    private  String emailhost;
    @Value("${spring.mail.username}")
    private  String fromemail;
    @Value("${spring.mail.password}")
    private  String password;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleEmail(String subject, String text, String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(text);
        message.setTo(to);
        message.setFrom(fromemail);
        mailSender.send(message);
    }

    @Override
    public void sendHtmlMail(String subject, String text, String to) {

        MimeMessage mimeMessage = null;
        try {
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(subject);
            helper.setText(text,true);
            helper.setTo(to);
            helper.setFrom(fromemail);
        }catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);

    }

    @Override
    public void sendAttachMail(String subject, String text, String to,String filePath,String fileName,String fileType) {
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(subject);
            helper.setText(text,true);
            helper.setTo(to);
            helper.setFrom(fromemail);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(fileName+"."+fileType,file);
        }catch (Exception e){
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);
    }
}
