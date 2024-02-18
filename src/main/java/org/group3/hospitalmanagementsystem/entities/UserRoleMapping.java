package org.group3.hospitalmanagementsystem.entities;


import jakarta.persistence.*;

@Entity
public class UserRoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ur_id")
    private Integer urId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "ur_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ur_role_group_id", referencedColumnName = "rg_id")
    private RoleGroup urRoleGroup;

    @Column(name = "ur_user_id")
    private int userId;

    @Column(name = "user_role_id")
    private int roleId;

    public UserRoleMapping() {
    }

    public UserRoleMapping(int userId, int roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public RoleGroup getUrRoleGroup() {
        return urRoleGroup;
    }

    public void setUrRoleGroup(RoleGroup urRoleGroup) {
        this.urRoleGroup = urRoleGroup;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
