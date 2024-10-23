package com.example.Homework_2._0.service;

import com.example.Homework_2._0.employee.Employee;
import com.example.Homework_2._0.exception.EmployeeAlreadyAddedException;
import com.example.Homework_2._0.exception.EmployeeNotFoundException;
import com.example.Homework_2._0.validation.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<String, Employee> employees;

    private ValidationService validationService;

    public EmployeeService(ValidationService validationService) {
        this.validationService = validationService;
    }

    private static void initializeEmployees() {
        Map<Integer, Employee> employees = new HashMap<>();
        employees.put(1, new Employee("Sergey", "Ivanov", 1, 63_000));
        employees.put(2, new Employee("Anna", "Petrova", 3, 82_000));
        employees.put(3, new Employee("Valentin", "Stepanov", 2, 68_000));
        employees.put(4, new Employee("Anastasia", "Petrova", 4, 72_000));
        employees.put(5, new Employee("Petr", "Aleksandrov", 5, 91_000));
        employees.put(6, new Employee("Alexander", "Sidorov", 3, 78_000));
        employees.put(7, new Employee("Maria", "Khokhlova", 4, 89_000));
        employees.put(8, new Employee("Igor", "Karpov", 2, 94_000));
        employees.put(9, new Employee("Julia", "Morozova", 1, 75_000));
        employees.put(10, new Employee("Maksim", "Tikhonov", 5, 88_000));
    }


    public Employee addEmployee(String firstName, String lastName, int departmentId, double salary) {
        validationService.validate(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, int departmentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Employee findEmployee(String firstName, String lastName, int departmentId, double salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
