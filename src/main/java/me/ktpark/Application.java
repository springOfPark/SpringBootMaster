package me.ktpark;

import me.ktpark.websvc.base.extension.TransactionSpec;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;


// @SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
        basePackageClasses = Application.class
        , includeFilters = { @Filter(type = FilterType.ANNOTATION, classes = TransactionSpec.class) }
)
@PropertySource("classpath:/config/boardApplication.properties")
public class Application {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(Application.class);
        // springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

}
