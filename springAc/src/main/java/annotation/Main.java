package annotation;

import annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-loader-context2.xml");
        //获取userController实例
        UserController userController = context.getBean("userController", UserController.class);
        //调用userController 中的save方法
        userController.save();
    }
}
