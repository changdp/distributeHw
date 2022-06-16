package annotation.controller;

import annotation.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

//使用　@Controller将UserController类标识为Spring中的Bean
@Controller("userController")
public class UserController {

    //使用@Resource注解注入
    @Resource(name = "userService")
    private UserService userService;

    public void save() {
        userService.save();
        System.out.println("运行 userController.save()");
    }
}

