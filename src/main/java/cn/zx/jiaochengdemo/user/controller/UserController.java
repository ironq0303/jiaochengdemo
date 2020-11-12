package cn.zx.jiaochengdemo.user.controller;

import cn.zx.jiaochengdemo.user.entity.UserEntity;
import cn.zx.jiaochengdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;

/**
 * @RestController=@ResponseBody+@Controller
 * Controller层：接受前端发来的数据，返回后端传来的数据
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<UserEntity> getAll(Map map) {
        System.out.println(userService.getAll(map));
        return userService.getAll(map);
    }
    @RequestMapping("/delById")
    public String delById(Integer id){
        userService.delById(id);
        return "redirect:/index.html";
    }
    @RequestMapping("/save")
    @ResponseBody
    public String save(@RequestBody UserEntity userEntity){
        userService.save(userEntity);
        return "success";
    }
}

