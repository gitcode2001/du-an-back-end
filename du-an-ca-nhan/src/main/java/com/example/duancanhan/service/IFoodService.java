package com.example.duancanhan.service;



import com.example.duancanhan.model.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodService {
    List<Food> getAllFoods();
    Optional<Food> getFoodById(Long id);
    Food saveFood(Food food);
    Food updateFood(Long id, Food updatedFood);
    void deleteFood(Long id);
    List<Food> searchFoodByName(String name);
}
