package kiec.ireneusz.springsecurity.domain.user;

import javassist.NotFoundException;
import kiec.ireneusz.springsecurity.domain.user.dto.LoginApi;
import kiec.ireneusz.springsecurity.domain.user.dto.PasswordResetApi;
import kiec.ireneusz.springsecurity.domain.user.dto.RegisterApi;
import kiec.ireneusz.springsecurity.domain.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final LoginRepository loginRepository;
    private final RoleService roleService;

    @Autowired
    public LoginService(PasswordEncoder passwordEncoder, LoginRepository loginRepository, RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.loginRepository = loginRepository;
        this.roleService = roleService;
    }

    @Override
    public UserDTO loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDTO> userDTO = loginRepository.findByMail(username)
                .map(UserMapper::dto);

        return userDTO.orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }

    Login register(RegisterApi api, Person person) throws RoleNotFoundException {
        checkMail(api.getMail());
        Role role = roleService.getRole("USER");
        Login login = new Login(api.getMail(), passwordEncoder.encode(api.getPassword()), role, person);
        return loginRepository.save(login);
    }

    private void checkMail(String mail) {
        boolean unavailable = loginRepository.findByMail(mail).isPresent();
        if (unavailable)
            throw new RuntimeException("mail already taken");
    }

    void activate(String token) {
        Optional<Login> login = loginRepository.findByActivateToken(token);
        if (login.isPresent()) {
            login.get().activate();
            loginRepository.save(login.get());
        } else
            throw new RuntimeException("exception");
    }

    Login remindPassword(String mail) {
        Optional<Login> login = loginRepository.findByMail(mail);
        if (login.isPresent()) {
            login.get().remindPassword();
            return loginRepository.save(login.get());
        } else
            throw new RuntimeException("exception");
    }

    void resetPassword(String token, PasswordResetApi api) {
        checkNewPassword(api);
        Optional<Login> login = loginRepository.findByPasswordToken(token);
        if (login.isPresent()) {
            login.get().resetPassword(passwordEncoder.encode(api.getNewPassword()));
            loginRepository.save(login.get());
        } else
            throw new RuntimeException("exception");
    }

    private void checkNewPassword(PasswordResetApi api) {
        if (!api.getNewPassword().equals(api.getRepeatedPassword()))
            throw new RuntimeException("exception");
    }

}

