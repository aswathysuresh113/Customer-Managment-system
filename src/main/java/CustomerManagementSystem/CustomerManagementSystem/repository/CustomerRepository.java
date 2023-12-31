package CustomerManagementSystem.CustomerManagementSystem.repository;

import CustomerManagementSystem.CustomerManagementSystem.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   CustomerRepository extends CrudRepository<Customer,Long> {


    Customer findById(long id);

}
