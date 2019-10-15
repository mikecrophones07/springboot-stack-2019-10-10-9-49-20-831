package com.tw.apistackbase.Services;

import com.tw.apistackbase.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServices {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public void addMember(Employee employee){
        this.employeeList.add(employee);
    }

    public Employee findEmployee(Integer id){
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateEmployeeInfo(Employee employee){
        this.employeeList.set(employeeList.indexOf(findEmployee(employee.getId())), employee);
    }

    public void deleteEmployee(Integer id){
        this.employeeList.remove(findEmployee(id));
    }

}
