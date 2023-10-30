package CustomerManagementSystem.CustomerManagementSystem.controller;

import CustomerManagementSystem.CustomerManagementSystem.contract.CustomerRequest;
import CustomerManagementSystem.CustomerManagementSystem.model.Customer;
import CustomerManagementSystem.CustomerManagementSystem.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    void testGetAllCustomers() throws Exception{
        String path ="/getAll";
        Customer customer= new Customer();
        customer.setFirstName("abc");
        customer.setLastName("xyz");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);
        List<Customer> result = new ArrayList<>();
        result.add(customer);

        when(service.getAllCustomers()).thenReturn(result);

        mockMvc.perform(get("/customers/getAll"))
                .andExpect(status().isOk());


    }
    @Test
    void testGetCustomerById() throws Exception{
        String path = "/customers/get/1";
        Customer customer= new Customer();
        customer.setId(1L);
        customer.setFirstName("abc");
        customer.setLastName("xyz");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");


        when(service.getCustomer(customer.getId())).thenReturn(customer);

        mockMvc.perform(get(path))
                .andExpect(status().isOk());


    }

    @Test
    void testCustomerCreate()throws Exception{
        String path = "/customers/create";
        Customer customer= new Customer();
        customer.setFirstName("abc");
        customer.setLastName("xyz");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);
        CustomerRequest request = new CustomerRequest(customer.getFirstName(),
                customer.getLastName(),
                customer.getCity(),
                customer.getMobileNumber(),
                customer.getEmail());

        when(service.createCustomer(request)).thenReturn(1L);


            mockMvc.perform(post(path))
                .andExpect(status().isOk())
                .andExpect(content().string(customer.getId().toString()));

    }

    @Test
    void DeleteCustomerByIdTest()throws Exception{
        String path= "/customers/delete/1";
        Customer customer= new Customer();

        customer.setId(1L);

        when(service.deleteCustomer(customer.getId())).thenReturn("Customer deleted Successfully");


        mockMvc.perform(delete(path))
                .andExpect(status().isOk());

    }
}
