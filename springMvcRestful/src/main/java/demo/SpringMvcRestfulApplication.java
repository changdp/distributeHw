package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringMvcRestfulApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMvcRestfulApplication.class,args);
    }
}
