package com.learing.Springbootpractice.service;

import com.learing.Springbootpractice.entity.Department;
import com.learing.Springbootpractice.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);
   public List<Department> fetchDepartmentList();
   public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFoundException;
   public void deleteDepartmentByID(Long departmentId);
   public Department updateDepartmentByID(Long departmentId, Department department);
   public Department fetchDepartmentByCode(String departmentName);
}
