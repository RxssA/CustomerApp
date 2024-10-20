package ie.atu.week5.customerapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CustomerOrderController {

    private CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/customer-with-orders")
    public ResponseEntity<String> createCustomerWithOrders(@RequestBody CustomerOrderRequest customerOrderRequest) {
        customerOrderService.newCustomerNewOrder(customerOrderRequest);
        return ResponseEntity.ok("Customer and orders created successfully");
    }
}
