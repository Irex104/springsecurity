package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.domain.user.dto.UserDTO;

class UserMapper {

    public static UserDTO dto(Login login) {
        return UserDTO.builder()
                .id(login.getId())
                .mail(login.getMail())
                .password(login.getPassword())
                .firstName(login.getPerson().getFirstName())
                .lastName(login.getPerson().getLastName())
                .active(login.isActive())
                .authorities(login.getAuthorities())
                .build();
    }

}
