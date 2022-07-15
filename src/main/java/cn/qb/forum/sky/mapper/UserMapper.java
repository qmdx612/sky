package cn.qb.forum.sky.mapper;

import cn.qb.forum.sky.entity.User;

/**
 * 操作用户数据的持久层接口
 */
public interface UserMapper {
    /**
     * 根据用户id查找用户数据
     * @param id 用户ID
     * @return 用户信息的实体类
     */
    User findById(Integer id);

    /**
     * 插入一个新用户
     * @param user 提交的用户数据
     * @return 影响行数
     */
    Integer addNew(User user);

    /**
     * 根据用户名查找用户数据
     * @param username 提交的用户名
     * @return 查询到的用户数据
     */
    User findByUsername(String username);

    /**
     * 根据用户邮箱查找用户数据
     * @param email 提交的邮箱
     * @return 查询到的用户数据
     */
    User findByEmail(String email);

    /**
     * 改变用户状态
     * @param userId 提交的用户ID
     * @return 受影响的行数
     */
    Integer changeStatus(Integer userId);
}
