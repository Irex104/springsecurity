package kiec.ireneusz.springsecurity.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoleDTO {

    private Long id;
    private String name;

}
