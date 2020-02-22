package kiec.ireneusz.springsecurity.config;

//import org.springframework.http.HttpMethod;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/admin").authenticated()
                    .antMatchers(String.valueOf(HttpMethod.GET), "/user").hasAnyRole("USER","ADMIN")
                    .antMatchers(String.valueOf(HttpMethod.GET), "/*").permitAll()
                    .antMatchers(String.valueOf(HttpMethod.POST), "/login").hasAnyRole("USER","ADMIN")
                .and()
                    .cors();
    }

}
