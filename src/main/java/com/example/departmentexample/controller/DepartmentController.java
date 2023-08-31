package com.example.departmentexample.controller;

import com.example.departmentexample.entity.Department;
import com.example.departmentexample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(
            @RequestBody Department department
    ){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(
            @RequestBody Department department,
            @PathVariable("id") Long departmentId
    ){
        return departmentService.updateDepartment(
                department, departmentId
        );
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(
            @PathVariable("id") Long departmentId
    ){
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Success";
    }
}
