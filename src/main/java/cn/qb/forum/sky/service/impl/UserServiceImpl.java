package cn.qb.forum.sky.service.impl;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import cn.qb.forum.sky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 操作用户数据的实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return findById(id);
    }

    /**
     * 根据用户id查找用户数据
     * @param id
     * @return 用户信息的实体类
     */
    private User findById(Integer id){
        return userMapper.findById(id);
    }

}
