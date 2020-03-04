package ru.suslov.hr.entity.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue
    private long id;

    @Column()
    String name;

    @Column()
    String username;

    @Column()
    String password;

    @Column()
    private boolean enabled;

    public UserApp(String name, String password, boolean enabled) {
        this.name = name;
        this.password = password;
        this.enabled = enabled;
    }
}
