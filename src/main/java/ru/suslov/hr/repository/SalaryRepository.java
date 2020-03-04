package ru.suslov.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suslov.hr.entity.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
