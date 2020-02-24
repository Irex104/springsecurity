package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.domain.user.dto.PersonAPI;
import kiec.ireneusz.springsecurity.domain.user.dto.RegisterApi;
import kiec.ireneusz.springsecurity.untils.AbstractModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(schema = "public", name = "people")
@SequenceGenerator(schema = "public", name = "people_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class Person extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "people_seq_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "address")
//    private String address;
//
//    @Column(name = "telephone")
//    private String telephone;
//
//    @Column(name = "pesel")
//    private String pesel;
//
//    @Column(name = "salary")
//    private double salary;
//
//    @Column(name = "birth_date")
//    private LocalDate birthday;
//
//    @Column(name = "worked_date")
//    private LocalDate workedDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Person(RegisterApi api, Role role) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
        this.role = role;
    }

    public Person(PersonAPI api, Role role) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
//        this.address = api.getAddress();
//        this.telephone = api.getTelephone();
//        this.pesel = api.getPesel();
//        this.salary = api.getSalary();
//        this.birthday = LocalDate.parse(api.getBirthday());
//        this.workedDate = LocalDate.parse(api.getWorkedDate());
        this.role = role;
    }

    public void update(PersonAPI api, Role role) {
        this.firstName = api.getFirstName();
        this.lastName = api.getLastName();
//        this.address = api.getAddress();
//        this.telephone = api.getTelephone();
//        this.pesel = api.getPesel();
//        this.salary = api.getSalary();
//        this.birthday = LocalDate.parse(api.getBirthday());
//        this.workedDate = LocalDate.parse(api.getWorkedDate());
        this.role = role;
    }
}
