package cn.qb.forum.sky.demotest;

import cn.qb.forum.sky.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTest {
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendMail(){
        Context context = new Context();
        context.setVariable("username","秦宝");
        String content = templateEngine.process("/mail/demo",context);
        System.out.println("开始发送!");
        System.out.println(content);
        mailClient.handleSend("1584759317@qq.com","这是一个html",content);
        System.out.println("发送完成!");
    }
}
