

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("by.courses.java.web"))
                .paths(PathSelectors.any())
                .build();
    }

//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "NCC-LessonTasks Web",
//                "Web",
//                "1.0",
//                "urn:tos",
//                new Contact("Alex Nastin", "", "none"),
//                "",
//                "",
//                new ArrayList<>());
//        return apiInfo;
//    }
}
