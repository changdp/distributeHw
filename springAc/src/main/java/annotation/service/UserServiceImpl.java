package annotation.service;
import annotation.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    //使用 @Resource注解注入
    @Resource(name = "userDao")
    private UserDao userDao;

    public void save() {
        this.userDao.save();
        System.out.println("执行 userService.save()");
    }
}

