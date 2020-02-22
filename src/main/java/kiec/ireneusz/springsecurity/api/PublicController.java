package kiec.ireneusz.springsecurity.api;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello(){
        return "hello!";
    }

}
