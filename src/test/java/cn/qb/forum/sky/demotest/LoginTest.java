package cn.qb.forum.sky.demotest;

import cn.qb.forum.sky.util.SkyUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Random;
import java.util.UUID;

@SpringBootTest
public class LoginTest {

    @Value("${sky.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String path;

    @Test
    public void getUUID(){
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

    @Test
    public void getMD5(){
        String line = "qinbao";
        String md5 = DigestUtils.md5DigestAsHex(line.getBytes());
        System.out.println(md5);
        System.out.println(md5.length());
    }

    @Test
    public  void utilTest(){
        String line1 = "";
        String line2 = null;
        String line3 = " ";
        String line4 = "   ";
        boolean off =StringUtils.isBlank(line1);
        System.out.println("空白字符串是否为空："+off);
        off =StringUtils.isBlank(line2);
        System.out.println("null字符串是否为空："+off);
        off =StringUtils.isBlank(line3);
        System.out.println("一个空格字符串是否为空："+off);
        off =StringUtils.isBlank(line4);
        System.out.println("多空格字符串是否为空："+off);
    }

    @Test
    public void uitl(){
        System.out.println(SkyUtil.getUUID());
        System.out.println(SkyUtil.getMD5("nihao"));
        System.out.println(SkyUtil.getUUID());
    }

    @Test
    public void random(){
        String line = String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000));
        System.out.println(line);
    }

    @Test
    public void value(){
        System.out.println(domain+path);
    }
}
