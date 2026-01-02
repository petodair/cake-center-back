package br.com.cake_center_back.service;

import br.com.cake_center_back.entities.Order;
import br.com.cake_center_back.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        return this.orderRepository.findById(id).orElse(null);
    }

}
