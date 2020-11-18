package week5.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("week5.spring.javaconfig")
public class StudentConfig {

    public StudentConfig() {
        System.out.println("StudentConfig init...");

    }

    @Bean
    @Scope("prototype")
    public StudentBean studentBean() {
        return new StudentBean();
    }

}
