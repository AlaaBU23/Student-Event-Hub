package CS673.SpringBootStudentEventHub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Front-end controller tester
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TestController {
    public String test(){
        return "ok";
    }
}
