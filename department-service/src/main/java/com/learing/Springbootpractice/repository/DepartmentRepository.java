package com.learing.Springbootpractice.repository;

import com.learing.Springbootpractice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //extending jpa repo for its existing methods
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //created this method and JPA query will do search based on attribute name added in method name "DepartmentCode"
    public Department findByDepartmentCode(String departmentCode);
    public Department findByDepartmentCodeIgnoreCase(String departmentCode);

}
