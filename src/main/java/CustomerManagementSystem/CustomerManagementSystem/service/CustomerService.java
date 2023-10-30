package CustomerManagementSystem.CustomerManagementSystem.service;

import CustomerManagementSystem.CustomerManagementSystem.contract.CustomerRequest;
import CustomerManagementSystem.CustomerManagementSystem.model.Customer;
import CustomerManagementSystem.CustomerManagementSystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public long createCustomer(CustomerRequest request){

        Customer customer = new Customer(request.getFirstName(), request.getLastName(), request.getCity(), request.getMobileNumber(), request.getEmail());
        Customer response=customerRepository.save(customer);
        return response.getId();
    }

    public List<Customer> getAllCustomers(){
        return (List<Customer>)this.customerRepository.findAll();

    }
    public Customer getCustomer(long id){
        Customer customer = this.customerRepository.findById(id);
        if(customer == null){
            throw new  RuntimeException("Customer not found");
        }
        return customer;
    }

    public  String deleteCustomer(long id){
        Customer customer = this.customerRepository.findById(id);
        if(customer == null){
            return "Customer not found";
        }
        else {
            customerRepository.deleteById(id);
            return "Customer deleted Successfully";
        }
    }

    public  Boolean updateCustomer(long id,CustomerRequest customerRequest){
        Customer customer = this.customerRepository.findById(id);
        if(customer == null){
           return false;
        }
        else {
            customer.setFirstName(customerRequest.getFirstName());
            customer.setLastName(customerRequest.getLastName());
            customer.setCity(customerRequest.getCity());
            customer.setMobileNumber(customerRequest.getMobileNumber());
            customer.setEmail(customerRequest.getEmail());
            customerRepository.save(customer);
            return true;


        }
    }
}
