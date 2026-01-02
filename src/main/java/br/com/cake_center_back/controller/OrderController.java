package br.com.cake_center_back.controller;

import br.com.cake_center_back.entities.Order;
import br.com.cake_center_back.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/order")
class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = this.orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = this.orderService.findById(id);
        return ResponseEntity.ok(order);
    }

}
