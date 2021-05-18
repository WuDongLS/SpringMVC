package com.atguigu.Controller;


import com.atguigu.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
//@RequestMapping("/test?")
public class HelloControl {
    @Autowired
    private JdbcTemplate template;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String Get(@RequestParam(value = "id")Integer id,ModelMap modelMap){
        String sql = "select * from t_user where id = ?";
        RowMapper rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user  = (User)template.queryForObject(sql, rowMapper, id);
        System.out.println(user);
        modelMap.addAttribute("msg","查询");
        return "hello";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String Post(User user, ModelMap modelMap){
        String sql = "insert into t_user values (?,?,?,?)";
        template.update(sql,user.getId(),user.getUsername(),user.getPassword(),user.getEmail());
        System.out.println(user);
        modelMap.addAttribute("msg","添加");
        return "hello";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.DELETE)
    public String Delete(@RequestParam("id")Integer id,ModelMap modelMap){
        String sql = "delete from t_user where id = ?";
        int update = template.update(sql, id);
        System.out.println("删除：" + update);
        modelMap.addAttribute("msg","删除");
        return "hello";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    public String Put(User user,ModelMap modelMap){
        String sql = "update t_user set username=?,password=?,email=? where id=?";
        modelMap.addAttribute("msg","修改");
        int update = template.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
        System.out.println("修改：" + update);
        modelMap.addAttribute("msg","修改");
        return "hello";
    }

    @RequestMapping("/hello") 
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","很好");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}
