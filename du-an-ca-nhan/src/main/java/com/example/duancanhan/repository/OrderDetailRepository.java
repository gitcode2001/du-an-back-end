package com.example.duancanhan.repository;



import com.example.duancanhan.dto.TopFoodDTO;
import com.example.duancanhan.model.OrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {
    @Query("SELECT new com.example.duancanhan.dto.TopFoodDTO(od.food.id, od.food.name, SUM(od.quantity)) " +
            "FROM OrderDetail od GROUP BY od.food.id, od.food.name ORDER BY SUM(od.quantity) DESC")
    List<TopFoodDTO> findTopSoldFoods();
}
