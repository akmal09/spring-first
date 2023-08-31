package com.example.departmentexample.service;

import com.example.departmentexample.entity.Department;
import com.example.departmentexample.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServicelmpi implements DepartmentService{

    @Autowired private DepartmentRepository departmentRepository;

    @Override public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override public List<Department> fetchDepartmentList(){
        return (List<Department>) departmentRepository.findAll();
    }

    @Override public Department updateDepartment(Department department, Long departmentId){
//        query department nya di query by id dulu
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentName(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentName(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override public void deleteDepartmentById(Long departmentId){
        departmentRepository.deleteById(departmentId);
    }
}

