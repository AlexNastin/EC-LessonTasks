package com.nastsin.ec.springweb;

import com.nastsin.ec.springweb.entity.Address;
import com.nastsin.ec.springweb.entity.User;
import com.nastsin.ec.springweb.repository.UserRepository;
import com.nastsin.ec.springweb.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories(basePackages = "com.nastsin.ec.springweb.repository")
public class SpringDataApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);

        Address address = new Address("testStreet", "testCity");
        User user = new User("testName");

        user.setAddress(address);
        address.setUser(user);

        UserService bean = context.getBean(UserService.class);
        bean.saveUser(user);
    }
}
