package ie.atu.week5.customerapp;

import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {
    private CustomerService customerService;
    private OrderService orderService;

    public CustomerOrderService(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    public void newCustomerNewOrder(CustomerOrderRequest customerOrderRequest) {
        customerService.create(customerOrderRequest.getCustomer());
        String customerId = customerOrderRequest.getCustomer().getId();

        for(Order order : orderService.getAllOrders()) {
            order.setCustomerId(customerId);
            orderService.addOrder(order);
        }
    }
}
