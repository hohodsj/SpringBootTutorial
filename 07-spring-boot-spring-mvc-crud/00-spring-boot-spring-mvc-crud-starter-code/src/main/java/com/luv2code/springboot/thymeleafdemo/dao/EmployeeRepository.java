package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    // Spring Data JPA will parse the method name look for specific format and pattern create query
    // find all by + order by last name asc
    // details: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    public List<Employee> findAllByOrderByLastNameAsc();

}
