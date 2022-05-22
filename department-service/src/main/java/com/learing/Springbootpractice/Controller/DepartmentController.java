package com.learing.Springbootpractice.Controller;

import com.learing.Springbootpractice.entity.Department;
import com.learing.Springbootpractice.error.DepartmentNotFoundException;
import com.learing.Springbootpractice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add") // add a new entry in the table & added valid annotation for not blank department name check
    public Department saveDepartment(@Valid @RequestBody Department department){
        // @RequestBody will tell spring to convert json data into department entity object
        log.info("Inside saveDepartment at DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/get") // fetch existing table entries
    public List<Department> fetchDepartmentList(){
        log.info("Inside fetchDepartmentList at DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/get/{id}") // search/fetch by Id
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentByID(departmentId);
    }

    @GetMapping("/get/name/{name}") // search/fetch by code/string data
    public Department fetchDepartmentByCode(@PathVariable("name") String departmentCode){
        return departmentService.fetchDepartmentByCode(departmentCode);
    }

    @DeleteMapping("/delete/{id}") // delete entry from table based on Id
    public String deleteDepartmentByID(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentByID(departmentId);
        return "Department entry has been deleted successfully";
    }

    @PutMapping("/update/{id}") // update an existing entry based on Id
    public Department updateDepartmentByID(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentByID(departmentId,department);
    }

}
