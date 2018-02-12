package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityManager entityManager;

    @GetMapping(path = "/add")
    public
    @ResponseBody
    String addNewUser(@RequestParam String firstName
            , @RequestParam String lastName) {

        Customer n = new Customer();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        customerRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public
    @ResponseBody
    Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/storedproc")
    public
    @ResponseBody
    Iterable<Customer> getUsersStoredProc() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("GetAllCustomers");
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }
}