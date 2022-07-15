package cn.qb.forum.sky.service;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 操作用户数据的业务层接口
 */
public interface UserService {
    /**
     * 根据用户的id查询用户数据
     * @param id 提交的yonghuid
     * @return 查询到的用户数据
     */
    User getById(Integer id);
}
