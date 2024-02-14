package org.group3.hospitalmanagementsystem.entities;


import jakarta.persistence.*;

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Integer adminId;

    @OneToOne
    @JoinColumn(name = "admin_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "admin_user_id")
    private Integer user_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "admin_role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
    private Role role;

    @Column(name = "admin_role_id")
    private Integer role_id;
}
