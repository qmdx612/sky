package cn.qb.forum.sky.mapper;

import cn.qb.forum.sky.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 对帖子数据进行操作的持久层接口
 */
public interface DiscussPostMapper {
    /**
     * 分页查询帖子数据
     * @param userId 根据用户id查询，动态不一定需要
     * @param offset 起始
     * @param limit  每页显示的最大帖子数量
     * @return 数据以集合形式返回
     */
    List<DiscussPost> findDiscussPost(@Param("userId") Integer userId,@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 查询帖子的总数量
     * @param userId 用户ID，动态参数，不一定使用
     * @return 总数量
     */
    Integer findCount(@Param("userId") Integer userId);
}
