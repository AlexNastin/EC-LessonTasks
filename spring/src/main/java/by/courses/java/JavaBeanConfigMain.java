package by.courses.java;

import by.courses.java.bean.Human;
import by.courses.java.bean.Roll;
import by.courses.java.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBeanConfigMain {

    public static void main(String[] args) {

        ApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);

        Human human2 = context2.getBean("human", Human.class);

        Roll roll = context2.getBean("roll", Roll.class);

        System.out.println(human2);

        System.out.println(roll);
    }
}
