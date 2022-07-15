package cn.qb.forum.sky.servicetest;

import cn.qb.forum.sky.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class DiscussPostServiceTest {
    @Autowired
    private DiscussPostService discussPostService;
    @Test
    public void getDiscussPosts(){
        List<Map<String,Object>> list = discussPostService.getDiscussPosts(0,0,10);
        for(Map<String,Object> map:list){
            System.out.println(map.get("discussPost"));
            System.out.println(map.get("user"));
        }
    }
}
