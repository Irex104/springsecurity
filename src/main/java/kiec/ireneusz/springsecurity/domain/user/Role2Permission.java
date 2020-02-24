package kiec.ireneusz.springsecurity.domain.user;

import kiec.ireneusz.springsecurity.untils.AbstractModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(schema = "public", name = "role2permission")
//@SequenceGenerator(schema = "public", name = "role2permission_seq_id", allocationSize = 1)
//@Getter
//@NoArgsConstructor
//class Role2Permission extends AbstractModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "role2permission_seq_id")
//    private Long id;
//
//    @NotNull
//    @Column(name = "role_id", nullable = false)
//    private Long roleId;
//
//    @NotNull
//    @Column(name = "permission_id", nullable = false)
//    private Long permissionId;
//
//    public Role2Permission(@NotNull Long roleId, @NotNull Long permissionId) {
//        this.roleId = roleId;
//        this.permissionId = permissionId;
//    }
//
//}
