package cn.qb.forum.sky.mappertest;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByid(){
        User user = userMapper.findById(101);
        System.out.println(user);
    }
}
