package com.zxl.order.service;

import com.zxl.order.Bean.Order;

public interface OrderService {
    Order getOrder(Long productId, Long userId);
}
