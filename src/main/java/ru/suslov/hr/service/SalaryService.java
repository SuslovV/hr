package ru.suslov.hr.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.suslov.hr.entity.Employee;
import ru.suslov.hr.entity.Salary;
import ru.suslov.hr.entity.SalaryDto;
import ru.suslov.hr.repository.EmployeeRepository;
import ru.suslov.hr.repository.SalaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    SalaryRepository salaryRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Salary> findAll() {
        List<Salary> list = new ArrayList<>();
        salaryRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(long id) {
        salaryRepository.deleteById(id);
    }

    public Salary findById(long id) {
        Optional<Salary> optionalSalary = salaryRepository.findById(id);
        return optionalSalary.isPresent() ? optionalSalary.get() : null;
    }

    public SalaryDto update(SalaryDto salaryDto) {
        Salary salary = findById(salaryDto.getId());
        if (salary != null) {
            BeanUtils.copyProperties(salaryDto, salary, "firstName", "lastName", "employee");
            salaryRepository.save(salary);
        }
        return salaryDto;
    }

    public Salary save(SalaryDto salary) {
        Salary newSalary = new Salary();
        if (salary.getId() == 0) {
            Employee employee = new Employee();
            employee.setFirstName(salary.getFirstName());
            employee.setLastName(salary.getLastName());
            employeeRepository.save(employee);
            newSalary.setEmployee(employee);
        } else {
            newSalary.setEmployee(employeeRepository.getById(salary.getId()));
        }
        newSalary.setAmount(salary.getAmount());
        return salaryRepository.save(newSalary);
    }
}
