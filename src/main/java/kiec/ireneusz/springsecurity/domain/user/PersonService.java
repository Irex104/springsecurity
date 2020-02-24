package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.domain.user.dto.PersonAPI;
import kiec.ireneusz.springsecurity.domain.user.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PeopleRepository repository;
    private final RoleRepository roleRepository;

    @Autowired
    public PersonService(PeopleRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public List<PersonDTO> getAll() {
        return repository.findAllByDeletedAtIsNull()
                .stream()
                .map(Mapper::toPersonDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO create(PersonAPI api) {
        Role role = roleRepository.getOne(api.getRoleId());
        Person person = new Person(api, role);
        person = repository.save(person);
        return Mapper.toPersonDTO(person);
    }

    public PersonDTO getOne(Long id) {
        Person person = repository.getOne(id);
        return Mapper.toPersonDTO(person);
    }

    public void update(Long id, PersonAPI api) {
        Role role = roleRepository.getOne(api.getRoleId());
        Person person = repository.getOne(id);
        person.update(api, role);
        repository.save(person);
    }

    public void delete(Long id) {
        Person person = repository.getOne(id);
        person.delete();
        repository.save(person);
    }

}
