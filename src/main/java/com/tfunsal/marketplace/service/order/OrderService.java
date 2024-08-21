package com.tfunsal.marketplace.service.order;

import com.tfunsal.marketplace.dto.OrderDto;
import com.tfunsal.marketplace.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(Long userId);

    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
