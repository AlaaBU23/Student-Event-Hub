package CS673.SpringBootStudentEventHub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
    public String test(){
        return "ok";
    }
}
