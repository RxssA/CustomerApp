package ie.atu.week5.customerapp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    @NotBlank(message = "Order Code should not be empty")
    private int orderCode;
    @NotBlank(message = "Order Details should not be empty")
    private String orderDetails;
    @NotBlank(message = "Order Date should not be empty")
    private String orderDate;
    @NotNull(message = "Customer ID should not be empty")
    private String customerId; // Reference to the associated customer
}
