package com.tw.apistackbase.controller;

import com.tw.apistackbase.Model.Employee;
import com.tw.apistackbase.Services.EmployeeServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();
    private EmployeeServices services = new EmployeeServices();

    @PostMapping(path = "/createMember", consumes = "application/json")
    public ResponseEntity<String> createMember(@RequestBody Employee employee) {
        services.addMember(employee);
        return ResponseEntity.ok("Added Member:" + employee.getName());
    }

    @GetMapping(path = "/getMember/{id}", produces = {"application/json"})
    public Employee getMember(@PathVariable Integer id){
        services.findEmployee(id);
        return services.findEmployee(id);
    }

    @PutMapping(path = "/updateEmployeeInfo", consumes = "application/json", produces = "application/json")
    public List<Employee> updateEmployeeInfo(@RequestBody Employee employee){
        services.updateEmployeeInfo(employee);
        return services.getEmployeeList();
    }

    @DeleteMapping(path = "/deleteEmployee/{id}", consumes = "application/json", produces = "application/json")
    public List<Employee> deleteEmployee(@PathVariable Integer id){
        services.deleteEmployee(id);
        return services.getEmployeeList();
    }
}
