package kiec.ireneusz.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs")
                .antMatchers("/webjars/**", "favicon.ico")
                .antMatchers(HttpMethod.OPTIONS);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/public/**", "/error")
                    .permitAll()
                    .and()
                .cors()
                    .and()
                .csrf()
                    .disable()
                .formLogin()
                    .disable()
                .httpBasic()
                    .disable();
    }

//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public AuthenticationProvider authProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(new BCryptPasswordEncoder());
//        return provider;
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
////                .httpBasic().and()
////                .authorizeRequests()
////                .antMatchers(String.valueOf(HttpMethod.GET), "/admin").hasRole("ADMIN")
////                .antMatchers(String.valueOf(HttpMethod.GET), "/user").hasAnyRole("USER","ADMIN")
////                .antMatchers(String.valueOf(HttpMethod.GET), "/*").permitAll()
////                .antMatchers(String.valueOf(HttpMethod.POST), "/login").hasAnyRole("USER","ADMIN");
//                .authorizeRequests()
//                .antMatchers("/admin*").hasRole("ADMIN")
//                .antMatchers("/user*").hasAnyRole("USER","ADMIN")
//                .antMatchers("/*").permitAll()
//                .and()
//                .formLogin().permitAll();
//    }
}
