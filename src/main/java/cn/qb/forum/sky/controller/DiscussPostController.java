package cn.qb.forum.sky.controller;

import cn.qb.forum.sky.entity.Page;
import cn.qb.forum.sky.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;

    @RequestMapping("/index")
    public String handleIndex(Model model, Page page){
        page.setRows(discussPostService.getCount(page.getUserId()));
        page.setPath("/index");
        List<Map<String,Object>> list = discussPostService.getDiscussPosts(page.getUserId(),page.getOffset(),page.getLimit());
        model.addAttribute("dates",list);
        return "/index";
    }
}
