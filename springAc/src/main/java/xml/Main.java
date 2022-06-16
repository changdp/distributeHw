package xml;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

public class Main {
    //main
    public static void main(String[] args) {
        // 使用xml装配
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-loader-context.xml");
        // 构造方法
        User userByConstructor = xmlApplicationContext.getBean("user-by-constructor", User.class);
        System.out.println(userByConstructor);
        // 使用静态方法装配
        User userByStaticMethod = xmlApplicationContext.getBean("user-by-static-method", User.class);
        System.out.println(userByStaticMethod);
        // ServiceLoader
        UserFactory userFactory = xmlApplicationContext.getBean("userFactoryServiceLoader", UserFactory.class);
        System.out.println(userFactory.createUser());
        // AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = xmlApplicationContext.getAutowireCapableBeanFactory();
        UserFactory userFactory2 = autowireCapableBeanFactory.createBean(AutowireFactory.class);
        System.out.println(userFactory2.createUser());
    }


}
