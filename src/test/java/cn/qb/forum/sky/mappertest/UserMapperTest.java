package cn.qb.forum.sky.mappertest;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByid(){
        User user = userMapper.findById(101);
        System.out.println(user);
    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("jjj");
        System.out.println(user);
    }

    @Test
    public void findByEmail(){
        User user = userMapper.findByEmail("nowcoder138@sina.com");
        System.out.println(user);
    }

    @Test
    public void addNew(){
        User user = new User();
        user.setUsername("qinbao");
        user.setPassword("qinbao612");
        user.setSalt("salt");
        user.setEmail("612@qq.com");
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode("612612");
        user.setHeaderUrl("www.www.www");
        user.setCreateTime(new Date());
        Integer rows = userMapper.addNew(user);
        System.out.println(rows);
    }
}
