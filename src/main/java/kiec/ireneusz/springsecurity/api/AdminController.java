package kiec.ireneusz.springsecurity.api;

import kiec.ireneusz.springsecurity.domain.user.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public AdminController(/*TokenEndpoint tokenEndpoint,*/ MyUserDetailsService myUserDetailsService) {
//        this.tokenEndpoint = tokenEndpoint;
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping
    public ResponseEntity<String> hello3(){
        return ResponseEntity.ok("hello admin!");
    }

}
