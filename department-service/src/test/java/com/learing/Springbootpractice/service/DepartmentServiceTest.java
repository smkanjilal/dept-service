package com.learing.Springbootpractice.service;

import com.learing.Springbootpractice.entity.Department;
import com.learing.Springbootpractice.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService; // need this object as we will call method of the class

    @MockBean
    private DepartmentRepository departmentRepository; // need it as repository class is called from the departmentService method

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentCode("IT")
                        .departmentName("Information Technology")
                        .departmentAddress("Kolkata")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentCodeIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void find_department_by_its_code(){
        String dept_code = "IT";
        Department dept_found = departmentService.fetchDepartmentByCode(dept_code);

        assertEquals(dept_code,dept_found.getDepartmentCode());
    }
}