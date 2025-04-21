package com.example.duancanhan.service.implement;


import com.example.duancanhan.model.Cart;
import com.example.duancanhan.model.Food;
import com.example.duancanhan.model.User;
import com.example.duancanhan.repository.CartRepository;
import com.example.duancanhan.repository.FoodRepository;
import com.example.duancanhan.repository.UserRepository;
import com.example.duancanhan.service.ICartService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public CartService(CartRepository cartRepository,
                       UserRepository userRepository,
                       FoodRepository foodRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }



    @Override
    public Cart saveCart(Cart cart) {
        if (cart.getUser() == null || cart.getUser().getId() == null) {
            throw new IllegalArgumentException("Thiếu thông tin người dùng.");
        }
        if (cart.getFood() == null || cart.getFood().getId() == null) {
            throw new IllegalArgumentException("Thiếu thông tin món ăn.");
        }

        Long userId = cart.getUser().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với ID " + userId));
        cart.setUser(user);

        Long foodId = cart.getFood().getId();
        Food food = foodRepository.findById(foodId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy món ăn với ID " + foodId));
        cart.setFood(food);

        return cartRepository.save(cart);
    }


    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> getCartsByUserId(Long userId) {
        return cartRepository.findByUser_Id(userId);
    }

    @Override
    public boolean checkoutCart(Long userId) {
        List<Cart> carts = cartRepository.findByUser_Id(userId);
        if (carts == null || carts.isEmpty()) {
            return false;
        }
        for (Cart cart : carts) {
            Food food = cart.getFood();
            String foodName = (food != null) ? food.getName() : "Không rõ";
            System.out.println("✅ Thanh toán sản phẩm: " + foodName);
        }
        cartRepository.deleteAll(carts);
        return true;
    }
}
