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
public class RoleApp {

    @Id
    @GeneratedValue
    private long id;

    @Column()
    String name;

    public RoleApp(String name) {
        this.name = name;
    }
}
