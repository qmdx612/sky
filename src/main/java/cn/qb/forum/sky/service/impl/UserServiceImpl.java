package cn.qb.forum.sky.service.impl;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.mapper.UserMapper;
import cn.qb.forum.sky.service.UserService;
import cn.qb.forum.sky.util.MailClient;
import cn.qb.forum.sky.util.SkyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 操作用户数据的实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private MailClient mailClient;

    @Value("${sky.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String path;

    @Override
    public User getById(Integer id) {
        return findById(id);
    }

    @Override
    public Map<String, Object> reg(User user) {
        Map<String,Object> map = new HashMap<>();

        //验证客户提交的数据是否完整
        if(StringUtils.isBlank(user.getUsername())){
            map.put("usernameMsg","用户名不能为空!");
            return map;
        }
        if(StringUtils.isBlank(user.getPassword())){
            map.put("passwordMsg","密码不能为空!");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())){
            map.put("emailMsg","邮箱不能为空!");
            return map;
        }

        //验证用户数据是否重复
        if(findByUsername(user.getUsername()) != null){
            map.put("usernameMsg","用户名已存在!");
            return map;
        }
        if(findByEmail(user.getEmail()) != null){
            map.put("emailMsg","邮箱已存在!");
            return map;
        }

        //补充用户数据
        String salt = SkyUtil.getUUID();
        user.setSalt(salt);
        String password = SkyUtil.getMD5(salt+user.getPassword()+salt);
        user.setPassword(password);
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(SkyUtil.getUUID());
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        user.setCreateTime(new Date());

        //插入用户数据
        addNew(user);

        //发送激活邮件
        Context context = new Context();
        context.setVariable("email",user.getEmail());
        //http://localhost:8080/sky/activation/id/code
        String url = domain+path+"/activation/"+user.getId()+"/"+user.getActivationCode();
        context.setVariable("url",url);
        String content = templateEngine.process("/mail/activation",context);
        mailClient.handleSend(user.getEmail(),"激活账号",content);

        return map;
    }

    @Override
    public Integer activation(Integer userId, String code) {
        User user = userMapper.findById(userId);
        if(user == null){
            return SkyUtil.ACTIVATION_FAILURE;
        }
        if(user.getStatus() == 1){
            return SkyUtil.ACTIVATION_REPEAT;
        }
        if(user.getActivationCode().equals(code)){
            changeStatus(userId);
            return SkyUtil.ACTIVATION_SUCCESS;
        }else{
            return SkyUtil.ACTIVATION_FAILURE;
        }
    }

    /**
     * 根据用户id查找用户数据
     * @param id 提交的用户ID
     * @return 用户信息的实体类
     */
    private User findById(Integer id){
        return userMapper.findById(id);
    }

    /**
     * 根据用户名查找用户数据
     * @param username 提交的用户名
     * @return 查询到的用户数据
     */
    private User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

    /**
     * 根据用户邮箱查找用户数据
     * @param email 提交的邮箱
     * @return 查询到的用户数据
     */
    private User findByEmail(String email){
        return userMapper.findByEmail(email);
    }

    /**
     * 插入一个新用户
     * @param user 提交的用户数据
     */
    private void addNew(User user){
        userMapper.addNew(user);
    }

    /**
     * 改变用户状态
     * @param userId 提交的用户ID
     */
    private void changeStatus(Integer userId){
        userMapper.changeStatus(userId);
    }
}
