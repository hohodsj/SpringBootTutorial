package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entityManager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }


    @Override
    public Employee findById(int theId) {
        // get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        
        // save employee
        // This performs upsert (if id == 0 insert else update)
        Employee dbEmployee = entityManager.merge(theEmployee);

        // return the dbEmployee
        return dbEmployee;
    }


    @Override
    public void deleteById(int theId) {
        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);
    }
    
    
}
