package com.learing.Springbootpractice.repository;

import com.learing.Springbootpractice.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        //.departmentId(1L)
                        .departmentAddress("Delhi")
                        .departmentCode("HR")
                        .departmentName("Human Resource")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void find_dept_by_id_return_dept(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Human Resource");
    }
}