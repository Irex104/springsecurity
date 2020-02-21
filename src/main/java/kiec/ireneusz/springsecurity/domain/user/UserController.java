package kiec.ireneusz.springsecurity.domain.user;

import javassist.NotFoundException;
import kiec.ireneusz.springsecurity.domain.user.login.LoginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

//    private final TokenEndpoint tokenEndpoint;
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserController(/*TokenEndpoint tokenEndpoint,*/ MyUserDetailsService myUserDetailsService) {
//        this.tokenEndpoint = tokenEndpoint;
        this.myUserDetailsService = myUserDetailsService;
    }

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

    @PostMapping("/login")
    public void login(LoginApi api) throws NotFoundException{
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(api.getUsername());
    }

    @GetMapping("/logout")
    public void logout(
            @AuthenticationPrincipal @ApiIgnore User user,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            SecurityContextLogoutHandler logout = new SecurityContextLogoutHandler();
        logout.setClearAuthentication(true);
        logout.logout(request,response, auth);
        }
    }

}
