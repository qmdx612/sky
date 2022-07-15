package cn.qb.forum.sky.servicetest;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;


    @Test
    public void getById(){
        User user = userService.getById(101);
        System.out.println(user);
    }
}
