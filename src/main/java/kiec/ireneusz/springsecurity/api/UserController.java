package kiec.ireneusz.springsecurity.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.springsecurity.domain.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/")
@Api(tags = "User", produces = "application/json", consumes = "application/json")
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<UserDTO> user(
            @ApiIgnore @AuthenticationPrincipal UserDTO userDTO
    ) {
        return ResponseEntity.ok()
                .body(userDTO);
    }

}
