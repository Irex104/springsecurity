package kiec.ireneusz.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @GetMapping("/user")
    public String hello2(){
        return "hello user!";
    }

    @GetMapping("/admin")
    public String hello3(){
        return "hello admin!";
    }

}
