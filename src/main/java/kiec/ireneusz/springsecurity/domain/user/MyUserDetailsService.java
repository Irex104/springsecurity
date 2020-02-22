package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.untils.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("User404");
        return new MyUserDetails(user);
    }

//    public FormResponse form() {
//        FormResponse form = new FormResponse();
//        BeanDefinitionDsl.Role.Name[] roles = Role.Name.values();
////        AdPublication.Range[] ranges = AdPublication.Range.values();
////        List<CurrencyDTO> currencies = commonFacade.getCurrencies();
//
//        form.addForm("roles", roles);
////        form.addForm("ranges", ranges);
////        form.addForm("currencies", currencies);
//        return form;
//    }


}

