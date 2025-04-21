package com.example.duancanhan.service;



import com.example.duancanhan.model.OrderStatus;

import java.util.List;

public interface IOrderStatusService {
    List<OrderStatus> findAll();
    OrderStatus findById(Long id);
    OrderStatus create(OrderStatus orderStatus);
    OrderStatus update(Long id, OrderStatus orderStatus);
    void delete(Long id);
}
