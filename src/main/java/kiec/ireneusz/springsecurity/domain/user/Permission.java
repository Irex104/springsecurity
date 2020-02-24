package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.untils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

//@Entity
//@Table(schema = "public", name = "permissions")
//@SequenceGenerator(schema = "public", name = "permission_seq_id", allocationSize = 1)
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//class Permission extends AbstractModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "permission_seq_id")
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "group_name", nullable = false)
//    private String groupName;
//
//    @Column(name = "permission", nullable = false)
//    private String permission;
//
//    static Permission systemUserRole() {
//        return new Permission(null, "user", "SYSTEM", "ROLE_USER");
//    }
//
//}