package springboot30.springboot30.service;

import org.springframework.stereotype.Service;
import springboot30.springboot30.dto.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }

    public  List<Customer> getCustomers(){
        return customers;
    }

    public Customer findByCustomerId(int id){
        return customers.stream().filter(c-> c.id()==id).findAny().orElseThrow(()-> new RuntimeException("Id not found"));
    }
}
