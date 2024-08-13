package com.tfunsal.marketplace.service.cart;

import com.tfunsal.marketplace.model.CartItem;

public interface CartItemService {

    void addItemToCart(Long cartId, Long productId, int quantity);

    void removeItemToCart(Long cartId, Long productId);

    void updateItemQuantity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);

}