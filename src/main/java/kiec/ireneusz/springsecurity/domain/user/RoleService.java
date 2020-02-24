package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.domain.user.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRole(String roleName) throws RoleNotFoundException {
        Optional<Role> role = roleRepository.findByName(roleName);
        return role.orElseThrow(RoleNotFoundException::new);
    }

    public List<RoleDTO> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(Mapper::toRoleDTO)
                .collect(Collectors.toList());
    }

    public RoleDTO create(String name) {
        Role role = new Role(name);
        role = roleRepository.save(role);
        return Mapper.toRoleDTO(role);
    }

    public void delete(Long id) {
        Role role = roleRepository.getOne(id);
        roleRepository.delete(role);
    }
}
