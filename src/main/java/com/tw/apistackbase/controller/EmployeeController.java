package com.tw.apistackbase.controller;

import com.tw.apistackbase.Model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @PostMapping(path = "/createMember", consumes = "application/json")
    public ResponseEntity<String> createMember(@RequestBody Employee employee) {
        employeeList.add(employee);
        return ResponseEntity.ok("Added Member:" + employee.getName());
    }

    @GetMapping(path = "/getMember/{id}", produces = {"application/json"})
    public Employee getMember(@PathVariable Integer id){
        return  employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

}
