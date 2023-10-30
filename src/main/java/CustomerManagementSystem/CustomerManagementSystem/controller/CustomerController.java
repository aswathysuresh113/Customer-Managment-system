package CustomerManagementSystem.CustomerManagementSystem.controller;


import CustomerManagementSystem.CustomerManagementSystem.contract.CustomerRequest;
import CustomerManagementSystem.CustomerManagementSystem.model.Customer;
import CustomerManagementSystem.CustomerManagementSystem.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    public  CustomerController(CustomerService customerService){

        this.customerService =customerService;
    }
    @PostMapping("/create")
    public @ResponseBody Long createCustomers(@RequestBody CustomerRequest customer){
        return this.customerService.createCustomer(customer);
    }

    @RequestMapping("/getAll")
    public @ResponseBody List<Customer> getAllCustomer(){
        return this.customerService.getAllCustomers();
    }
    @RequestMapping("/get/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable long id){

        return this.customerService.getCustomer(id);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteCustomerById(@PathVariable long id){

        return this.customerService.deleteCustomer(id);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody Boolean updateCustomerById(@PathVariable long id, @RequestBody CustomerRequest customerRequest){

        return this.customerService.updateCustomer(id, customerRequest);
    }

}
