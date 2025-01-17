package com.example.Homework_2._0.controller;

import com.example.Homework_2._0.employee.Employee;
import com.example.Homework_2._0.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return departmentService.getMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployee(@RequestParam("departmentId") int departmentId) {
        return departmentService.getMinSalaryEmployee(departmentId);
    }

    @GetMapping("/all/by-department")
    public List<Employee> getAllEmployeeByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.getAllEmployeeByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
