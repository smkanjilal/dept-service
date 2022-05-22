package com.learing.Springbootpractice.service;

import com.learing.Springbootpractice.entity.Department;
import com.learing.Springbootpractice.error.DepartmentNotFoundException;
import com.learing.Springbootpractice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Departmant is not available!!");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentByID(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentByID(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        //notnull & empty check
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    // implemented the below menthod using JPA query
    public Department fetchDepartmentByCode(String departmentCode) {
        // return departmentRepository.findByDepartmentCodeIgnoreCase(departmentCode); -- exact string match
        return departmentRepository.findByDepartmentCodeIgnoreCase(departmentCode); // string match by ignoring case
    }
}
