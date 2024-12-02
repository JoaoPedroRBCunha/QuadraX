package com.quadras.QuadraX.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quadras.QuadraX.entities.OrderItem;
import com.quadras.QuadraX.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}