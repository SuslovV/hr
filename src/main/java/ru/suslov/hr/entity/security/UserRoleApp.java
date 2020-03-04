package ru.suslov.hr.entity.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
public class UserRoleApp {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userApp", nullable = false)
    private UserApp userApp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleApp", nullable = false)
    private RoleApp roleApp;

    public UserRoleApp(UserApp userApp, RoleApp roleApp) {
        this.userApp = userApp;
        this.roleApp = roleApp;
    }
}
