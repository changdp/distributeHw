package annotation.dao;

import org.springframework.stereotype.Repository;

//使用 @Repository注解将UserDaoImpl类标识为Spring中的Bean
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public void save() {
        System.out.println("执行 userDao.save()");
    }
}

