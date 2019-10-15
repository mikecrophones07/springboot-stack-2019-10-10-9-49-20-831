package com.tw.apistackbase.controller;

import com.tw.apistackbase.Model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> memberList = new ArrayList<>();

    @PostMapping(path = "/createMember", consumes = "application/json")
    public ResponseEntity<String> createMember(@RequestBody Employee employee) {
        memberList.add(employee);
        return ResponseEntity.ok("Added Member:" + employee.getName());
    }


}
