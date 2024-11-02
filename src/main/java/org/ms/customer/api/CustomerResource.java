package org.ms.customer.api;

import jakarta.ws.rs.*;
import org.ms.customer.entity.Customer;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.ms.customer.service.CustomerService;

import java.util.List;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    CustomerService customerService;

    @GET
    public Uni<List<Customer>> listCustomers() {
        return customerService.listAllCustomers();
    }

    @GET
    @Path("/{id}")
    public Uni<Customer> getCustomer(@PathParam("id") Long id) {
        return customerService.findCustomerById(id);
    }

    @POST
    public Uni<Customer> createCustomer(Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PUT
    @Path("/{id}")
    public Uni<Customer> updateCustomer(@PathParam("id") Long id, Customer updatedCustomer){
        return customerService.findCustomerById(id)
                .onItem().ifNotNull().transformToUni(existing -> {
                    existing.setName(updatedCustomer.getName());
                    existing.setEmail(updatedCustomer.getEmail());
                    existing.setPhone(updatedCustomer.getPhone());
                    return customerService.createCustomer(existing);
                });
    }

    @DELETE
    @Path("/{id}")
    public Uni<Boolean> deleteCustomer(@PathParam("id") Long id) {
        return customerService.deleteCustomer(id);
    }
}
