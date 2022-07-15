package cn.qb.forum.sky.service;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

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

    /**
     * 用户注册
     * @param user 提交的用户注册信息
     * @return 返回结果的提示信息
     */
    Map<String,Object> reg(User user);

    /**
     * 用户账号激活
     * @param userId 提交的用户ID
     * @param code 提交的用户激活码
     * @return 返回激活状态码
     */
    Integer activation(Integer userId,String code);
}
