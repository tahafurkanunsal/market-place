package com.tfunsal.marketplace.service.cart;

import com.tfunsal.marketplace.model.Cart;

import java.math.BigDecimal;

public interface CartService {

    Cart getCart(Long id);

    void clearCart(Long id);

    BigDecimal getTotalPrice(Long id);

    Long initializeNewCart();

}