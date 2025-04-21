package com.example.duancanhan.service;



import com.example.duancanhan.dto.TopFoodDTO;
import com.example.duancanhan.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> findAll();
    OrderDetail findById(Long id);
    OrderDetail create(OrderDetail orderDetail);
    OrderDetail update(Long id, OrderDetail orderDetail);
    void delete(Long id);
    List<TopFoodDTO> findTopSoldFoods();

}
