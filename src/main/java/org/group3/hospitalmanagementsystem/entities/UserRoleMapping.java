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

    @OneToOne
    @JoinColumn(name = "ur_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

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
}
