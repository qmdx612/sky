package cn.qb.forum.sky.controller;

import cn.qb.forum.sky.entity.User;
import cn.qb.forum.sky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String getRegPage(){
        return "/site/register";
    }

    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String handleReg(Model model, User user){
        Map<String,Object> map = userService.reg(user);
        if(map == null || map.isEmpty()){
            model.addAttribute("msg","注册完成，已发送一封激活邮件，请快点去激活加入我们吧!");
            model.addAttribute("target","/index");
            return "/site/operate-result";
        } else {
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            model.addAttribute("emailMsg",map.get("emailMsg"));
            return "/site/register";
        }
    }
    ////http://localhost:8080/sky/activation/id/code
    @RequestMapping(path = "/activation/{id}/{code}",method = RequestMethod.GET)
    public String handlerActivation(Model model,@PathVariable("id") Integer userId,@PathVariable("code") String code){
        Integer status_code = userService.activation(userId,code);
        if(status_code == 1){
            model.addAttribute("msg","账号激活成功，快来登录吧!");
            model.addAttribute("target","/login");
        }
        if(status_code == 2){
            model.addAttribute("msg","无效操作，账号已经激活成功!");
            model.addAttribute("target","/index");
        }
        if(status_code == 3){
            model.addAttribute("msg","激活失败，数据异常!");
            model.addAttribute("target","/index");
        }
        return "/site/operate-result";
    }

}
