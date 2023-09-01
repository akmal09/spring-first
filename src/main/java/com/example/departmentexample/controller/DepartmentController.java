package com.example.departmentexample.controller;

import com.example.departmentexample.entity.Department;
import com.example.departmentexample.helper.RequestJson;
import com.example.departmentexample.service.DepartmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired private DepartmentService departmentService;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

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

    @GetMapping("/tes")
    public static void tes(
            @RequestBody String tes
    ){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RequestJson requestJson = objectMapper.readValue(tes,RequestJson.class);
            System.out.println("Name: " + requestJson.getName());
            System.out.println("Age: " + requestJson.getAge());
            System.out.println("City: " + requestJson.getCity());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        logger.info("helooowjiaodsof "+ tes);
    }

}
