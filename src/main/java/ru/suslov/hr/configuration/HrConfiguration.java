package ru.suslov.hr.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import ru.suslov.hr.entity.Employee;
import ru.suslov.hr.entity.Salary;
import ru.suslov.hr.entity.security.RoleApp;
import ru.suslov.hr.entity.security.UserApp;
import ru.suslov.hr.entity.security.UserRoleApp;
import ru.suslov.hr.repository.EmployeeRepository;
import ru.suslov.hr.repository.SalaryRepository;
import ru.suslov.hr.repository.security.EncrytedPasswordUtils;
import ru.suslov.hr.repository.security.RoleAppRepository;
import ru.suslov.hr.repository.security.UserAppRepository;
import ru.suslov.hr.repository.security.UserRoleAppRepository;

public class HrConfiguration {

    @Bean
    public CommandLineRunner loadService(UserAppRepository userAppRepository, RoleAppRepository roleAppRepository,
                                         UserRoleAppRepository userRoleAppRepository, EmployeeRepository employeeRepository,
                                         SalaryRepository salaryRepository) {
        return args -> {
            roleAppRepository.save(new RoleApp("ROLE_USER"));
            roleAppRepository.save(new RoleApp("ROLE_ADMIN"));

            userAppRepository.save(new UserApp("dbuser1", EncrytedPasswordUtils.encrytePassword("123"), true));
            userAppRepository.save(new UserApp("dbadmin1", EncrytedPasswordUtils.encrytePassword("123"), true));

            userRoleAppRepository.save(new UserRoleApp(userAppRepository.findByName("dbuser1"), roleAppRepository.findByName("ROLE_USER")));
            userRoleAppRepository.save(new UserRoleApp(userAppRepository.findByName("dbadmin1"), roleAppRepository.findByName("ROLE_USER")));

            Employee employee = new Employee();
            employee.setFirstName("Иван");
            employee.setLastName("Сидоров");
            employeeRepository.save(employee);

            Salary newSalary = new Salary();
            newSalary.setEmployee(employee);
            newSalary.setEmployee(employee);
            newSalary.setAmount(55000);
            salaryRepository.save(newSalary);

            employee = new Employee();
            employee.setFirstName("Петр");
            employee.setLastName("Ломоносов");
            employeeRepository.save(employee);

            newSalary = new Salary();
            newSalary.setEmployee(employee);
            newSalary.setEmployee(employee);
            newSalary.setAmount(75000);
            salaryRepository.save(newSalary);
        };
    }
}
