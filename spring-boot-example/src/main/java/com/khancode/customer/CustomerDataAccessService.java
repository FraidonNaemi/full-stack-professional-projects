package com.khancode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao {

    // db
    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer ahmad = new Customer(
                1,
                "Ahmad",
                "ahmad@gmail.com",
                21
        );
        customers.add(ahmad);

        Customer ali = new Customer(
                2,
                "Ali",
                "ali@gmail.com",
                19
        );
        customers.add(ali);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}