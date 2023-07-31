package springboot30.springboot30.controller;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot30.springboot30.dto.Customer;
import springboot30.springboot30.httpclient.CustomTripServiceClient;
import springboot30.springboot30.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObservationRegistry observationRegistry;

    @Autowired
    private CustomTripServiceClient customTripServiceClient;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return Observation.createNotStarted("addCustomer", observationRegistry).observe(() -> customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return Observation.createNotStarted("getCustomers", observationRegistry).observe(() -> customerService.getCustomers());
    }

    @GetMapping("/{id}")
    public Customer findByCustomerId(@PathVariable int id) {
        return Observation.createNotStarted("findByCustomerId", observationRegistry).observe(() -> customerService.findByCustomerId(id));
    }

    @GetMapping("/custom-trip")
    public ResponseEntity<String> getCustomTripResponse(){
        return customTripServiceClient.getCustomTrip();
    }
}
