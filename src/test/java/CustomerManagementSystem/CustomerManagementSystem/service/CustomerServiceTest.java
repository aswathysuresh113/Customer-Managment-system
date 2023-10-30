package CustomerManagementSystem.CustomerManagementSystem.service;

import CustomerManagementSystem.CustomerManagementSystem.contract.CustomerRequest;
import CustomerManagementSystem.CustomerManagementSystem.model.Customer;
import CustomerManagementSystem.CustomerManagementSystem.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    private CustomerRepository customerRepository;

    private CustomerService customerService;
    @BeforeEach

    public void init(){
        MockitoAnnotations.openMocks(this);
        customerRepository= Mockito.mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }
    @Test
    void GetAllCustomersTest(){
        Customer customer= new Customer();
        customer.setFirstName("test");
        customer.setLastName("user");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);
        //CustomerRequest request = new CustomerRequest(entity.getFirstName(), entity.getLastName());
        List<Customer> result = new ArrayList<>();
        result.add(customer);
        when(customerRepository.findAll()).thenReturn(result);


        List<Customer> response= customerService.getAllCustomers();
        assertEquals(response,result);


    }

    @Test
    void GetCustomerByIdTest(){
        Customer customer= new Customer();
        customer.setFirstName("test");
        customer.setLastName("user");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);

        when(customerRepository.findById(1)).thenReturn(customer);


        Customer response= customerService.getCustomer(customer.getId());
        assertEquals(response,customer);


    }

    @Test
    void CreateCustomerTest(){
        Customer customer= new Customer();
        customer.setFirstName("test");
        customer.setLastName("user");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);
        CustomerRequest request = new CustomerRequest(customer.getFirstName(),
                customer.getLastName(),
                customer.getCity(),
                customer.getMobileNumber(),
                customer.getEmail());

        when(customerRepository.save(any())).thenReturn(customer);


        long id= customerService.createCustomer(request);
        assertEquals(id,1l);


    }

    @Test
    void DeleteCustomerByIdTest(){
        Customer customer= new Customer();
        customer.setFirstName("test");
        customer.setLastName("user");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);

        when(customerRepository.findById(1)).thenReturn(customer);


        String response= customerService.deleteCustomer(customer.getId());
        assertEquals(response,"Customer deleted Successfully");


    }

    @Test
    void UpdateCustomerTest(){
        Customer customer= new Customer();
        customer.setFirstName("test");
        customer.setLastName("user");
        customer.setCity("aaa");
        customer.setMobileNumber("12345");
        customer.setEmail("xyz@gmail.com");
        customer.setId(1L);

        CustomerRequest request = new CustomerRequest(customer.getFirstName(),
                customer.getLastName(),
                customer.getCity(),
                customer.getMobileNumber(),
                customer.getEmail());

        when(customerRepository.findById(1)).thenReturn(customer);


        Boolean result= customerService.updateCustomer(1,request);
        assertEquals(result,true);


    }

}