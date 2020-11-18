package Week05.spring.autocofig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoStudentBean {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
}
