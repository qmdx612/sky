package cn.qb.forum.sky.service.impl;

import cn.qb.forum.sky.entity.DiscussPost;
import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.DiscussPostMapper;
import cn.qb.forum.sky.service.DiscussPostService;
import cn.qb.forum.sky.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作帖子数据的业务层实现类
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private UserService userService;

    @Override
    public  List<Map<String,Object>>  getDiscussPosts(Integer userId, Integer offset, Integer limit) {
        List<DiscussPost> datas = findDiscussPost(userId,offset,limit);
        List<Map<String,Object>> list = new ArrayList<>();
        if(datas != null){
            for(DiscussPost discussPost:datas){
                Map<String,Object> map = new HashMap<>();
                User date = userService.getById(discussPost.getUserId());
                map.put("user",date);
                map.put("discussPost",discussPost);
                list.add(map);
            }
        }
        return list;
    }

    @Override
    public Integer getCount(Integer userId) {
        return findCount(userId);
    }

    /**
     * 分页查询帖子数据
     * @param userId 根据用户id查询，动态不一定需要
     * @param offset 页数
     * @param limit  每页显示的最大帖子数量
     * @return 数据以集合形式返回
     */
    private List<DiscussPost> findDiscussPost(Integer userId,Integer offset,Integer limit){
        return discussPostMapper.findDiscussPost(userId,offset,limit);
    }

    /**
     * 查询帖子的总数量
     * @param userId 用户ID，动态参数，不一定使用
     * @return 总数量
     */
    private Integer findCount(@Param("userId") Integer userId){
        return discussPostMapper.findCount(userId);
    }
}
