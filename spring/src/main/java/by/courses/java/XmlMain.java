package by.courses.java;

import by.courses.java.bean.Camera;
import by.courses.java.bean.Human;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

//        int beanDefinitionCount = context.getBeanDefinitionCount();
//        System.out.println(beanDefinitionCount);

        Camera camera = context.getBean("camera", Camera.class);

//        Roll roll = context.getBean("roll", Roll.class);
//
        Human human = context.getBean("human", Human.class);

        System.out.println(camera);

//        System.out.println(roll);

        System.out.println(human);
    }
}
