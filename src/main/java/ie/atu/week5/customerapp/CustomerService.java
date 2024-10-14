package ie.atu.week5.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private Customer customer;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customer = customer;
    }
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public ResponseEntity<Customer> getCustomerById(String id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void create(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> delete(String id){
        customerRepository.deleteById(id);
        return customerRepository.findAll();
    }
}
