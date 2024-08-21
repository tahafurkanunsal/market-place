package com.tfunsal.marketplace.service.cart;

import com.tfunsal.marketplace.model.Cart;
import com.tfunsal.marketplace.model.User;

import java.math.BigDecimal;

public interface CartService {

    Cart getCart(Long id);

    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}