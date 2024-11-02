package org.ms.customer.service;

import org.ms.customer.entity.Customer;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.ms.customer.repository.CustomerRepository;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;

    public Uni<List<Customer>> listAllCustomers() {
        return customerRepository.listAll();
    }

    public Uni<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Uni<Customer> createCustomer(Customer customer){
        return customerRepository.persist(customer);
    }

    public Uni<Boolean> deleteCustomer(Long id) {
        return customerRepository.deleteById(id);
    }
}