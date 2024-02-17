package org.group3.hospitalmanagementsystem.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role_group")
public class RoleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rg_id")
    private Long rgId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "urRoleGroup")
    private Set<UserRoleMapping> userRoleMappings;

    public RoleGroup() {
    }

    public Long getRgId() {
        return rgId;
    }

    public void setRgId(Long rgId) {
        this.rgId = rgId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<UserRoleMapping> getUserRoleMappings() {
        return userRoleMappings;
    }

    public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
        this.userRoleMappings = userRoleMappings;
    }
}
