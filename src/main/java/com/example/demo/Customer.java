package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "Customer")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetAllCustomers",
                procedureName = "test.GetAllCustomers",
                resultClasses = com.example.demo.Customer.class
        )
})
public class Customer implements Serializable{
    @Id
    @GeneratedValue
    private BigInteger id;

    private String first_name;
    private String last_name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
}
