package br.com.cake_center_back.repository;

import br.com.cake_center_back.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}