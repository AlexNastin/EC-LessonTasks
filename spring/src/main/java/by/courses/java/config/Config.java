package by.courses.java.config;

import by.courses.java.bean.Human;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "by.courses.java")
public class Config {

    @Bean
    public Human human() {
        return new Human("Alex");
    }
}
