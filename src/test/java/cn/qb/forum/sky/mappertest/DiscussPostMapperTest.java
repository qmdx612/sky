package cn.qb.forum.sky.mappertest;

import cn.qb.forum.sky.entity.DiscussPost;
import cn.qb.forum.sky.mapper.DiscussPostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DiscussPostMapperTest {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void findDiscussPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.findDiscussPost(101,0,10);
        for(DiscussPost discuss:discussPosts){
            System.out.println(discuss);
        }
    }
    @Test
    public void findCount(){
        System.out.println(discussPostMapper.findCount(101));
    }
}
