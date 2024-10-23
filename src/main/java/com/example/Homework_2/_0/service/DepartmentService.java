package com.example.Homework_2._0.service;

import com.example.Homework_2._0.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getAllEmployeeByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(emp -> emp.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
