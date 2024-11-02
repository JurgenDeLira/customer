package org.ms.customer.repository;

import org.ms.customer.entity.Customer;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

}
