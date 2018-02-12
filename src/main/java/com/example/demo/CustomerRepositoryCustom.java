package com.example.demo;

import org.springframework.data.jpa.repository.query.Procedure;

public interface CustomerRepositoryCustom {
    @Procedure(name = "GetAllCustomersSP")
    Object[] getAllCustomersSP();
}
