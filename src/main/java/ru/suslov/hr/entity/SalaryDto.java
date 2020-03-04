package ru.suslov.hr.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryDto {

    private long id;
    private Employee employee;
    private String firstName;
    private String lastName;
    private float amount;
}
