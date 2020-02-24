package kiec.ireneusz.springsecurity.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterApi {

    private String mail;
    private String password;
    private String firstName;
    private String lastName;

}
