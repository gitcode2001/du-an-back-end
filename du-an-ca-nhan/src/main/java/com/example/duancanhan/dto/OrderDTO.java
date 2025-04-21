package com.example.duancanhan.dto;


import com.example.duancanhan.model.Order;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long id;
    private Double totalPrice;
    private Order.Status status;
    private Order.PaymentMethod paymentMethod;
    private LocalDateTime createdAt;
    private UserDTO user;

    public OrderDTO(Order order) {
        if (order != null) {
            this.id = order.getId();
            this.totalPrice = order.getTotalPrice();
            this.status = order.getStatus();
            this.paymentMethod = order.getPaymentMethod();
            this.createdAt = order.getCreatedAt();
            if (order.getUser() != null) {
                this.user = new UserDTO(order.getUser());
            }
        }
    }
}
