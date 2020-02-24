package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.domain.user.dto.PasswordResetApi;
import kiec.ireneusz.springsecurity.domain.user.dto.RegisterApi;
import kiec.ireneusz.springsecurity.domain.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;

@Service
public class UserFacade {

    private final LoginService loginService;
    private final PeopleService peopleService;

    @Autowired
    public UserFacade(LoginService loginService, PeopleService peopleService) {
        this.loginService = loginService;
        this.peopleService = peopleService;
    }

    public void register(RegisterApi api) throws RoleNotFoundException {
        Person person = peopleService.create(api);
        Login login = loginService.register(api, person);
        UserDTO userDTO = UserMapper.dto(login);
    }

    public void activateUser(String token) {
        loginService.activate(token);
    }

    public void remindUserPassword(String mail) {
        Login login = loginService.remindPassword(mail);
        UserDTO userDTO = UserMapper.dto(login);
    }

    public void resetUserPassword(String token, PasswordResetApi api) {
        loginService.resetPassword(token, api);
    }
}
