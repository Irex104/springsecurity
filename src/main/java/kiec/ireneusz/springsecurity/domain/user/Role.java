package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.untils.AbstractModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(schema = "public", name = "roles")
@SequenceGenerator(schema = "public", name = "role_seq_id", allocationSize = 1)
@Getter
@NoArgsConstructor
public class Role extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role_seq_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "public", name = "role2permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Collection<Permission> permissionList = new ArrayList<>();

    public Role(String userRoleName) {
        this.name = userRoleName;
        this.permissionList = new ArrayList<>();
    }

}
