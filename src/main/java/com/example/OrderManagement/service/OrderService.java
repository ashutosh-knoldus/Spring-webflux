package com.example.OrderManagement.service;

import com.example.OrderManagement.model.OrderRequest;
import com.example.OrderManagement.model.OrderRepository;
import com.example.OrderManagement.model.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

/**
 * This class is a Service class, which is having method which contains the business logic
 * and also calling of repository class methods.
 * and returning the response to controller class.
 * */
@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    public Mono<OrderResponse> create(OrderRequest order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(UUID.randomUUID().toString());
        orderResponse.setOrderRequest(order);
        return orderRepository.save(orderResponse);
    }

    public Mono<OrderResponse> findById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public Flux<OrderResponse> findAll() {
        Flux<OrderResponse> all = orderRepository.findAll();
        //TODO:
        return all.delayElements(Duration.ofSeconds(2));
    }

    public Mono<OrderResponse> update(OrderResponse order) {
        return orderRepository.save(order);
    }

    public Mono<Void> delete(String orderId) {
        return orderRepository.deleteById(orderId);
    }
}
