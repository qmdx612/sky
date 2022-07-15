package cn.qb.forum.sky.mapper;

import cn.qb.forum.sky.entity.User;

/**
 * 操作用户数据的持久层接口
 */
public interface UserMapper {
    /**
     * 根据用户id查找用户数据
     * @param id
     * @return 用户信息的实体类
     */
    User findById(Integer id);
}
