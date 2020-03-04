package ru.suslov.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.suslov.hr.entity.ApiResponse;
import ru.suslov.hr.entity.Salary;
import ru.suslov.hr.entity.SalaryDto;
import ru.suslov.hr.service.SalaryService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @PostMapping
    public ApiResponse<Salary> saveSalary(@RequestBody SalaryDto salary) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Salary saved successfully.", salaryService.save(salary));
    }

    @GetMapping
    public ApiResponse<List<Salary>> listSalary() {
        return new ApiResponse<>(HttpStatus.OK.value(), "Salary list fetched successfully.", salaryService.findAll());
    }

    @RequestMapping(value = "/add-salary", method = RequestMethod.GET)
    public String addSalary() {
        return "1";
        //return new ApiResponse<>(HttpStatus.OK.value(), "Salary new", null);
    }

    @GetMapping("/{id}")
    public ApiResponse<Salary> getOne(@PathVariable int id) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Salary fetched successfully.", salaryService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<SalaryDto> update(@RequestBody SalaryDto salaryDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Salary updated successfully.", salaryService.update(salaryDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        salaryService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Salary deleted successfully.", null);
    }
}
