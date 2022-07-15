package cn.qb.forum.sky.service;

import cn.qb.forum.sky.entity.DiscussPost;

import java.util.List;
import java.util.Map;

/**
 * 操作帖子数据的业务层接口
 */
public interface DiscussPostService {
    /**
     * 获得具体的帖子信息
     * @param userId
     * @param offset
     * @param limit
     * @return 以集合的形式返回
     */
    List<Map<String,Object>>  getDiscussPosts(Integer userId, Integer offset, Integer limit);

    /**
     * 获得总数据量
     * @param userId
     * @return 帖子的总数
     */
    Integer getCount(Integer userId);
}
