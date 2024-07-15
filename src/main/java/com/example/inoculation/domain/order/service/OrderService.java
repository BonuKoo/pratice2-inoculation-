package com.example.inoculation.domain.order.service;

import com.example.inoculation.domain.injection.dto.InjectionStatsDTO;
import com.example.inoculation.domain.order.Order;
import com.example.inoculation.domain.order.dto.OrderDTO;
import com.example.inoculation.domain.order.dto.OrderListDTO;
import com.example.inoculation.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderListDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(OrderListDTO::fromOrder).collect(Collectors.toList());
    }

    public List<InjectionStatsDTO> getInjectionStats() {
        List<Order> orders = orderRepository.findAll();
        Map<String, InjectionStatsDTO> statsMap = new HashMap<>();

        for (Order order : orders) {
            String iCode = order.getInjection().getI_code();
            InjectionStatsDTO stats = statsMap.getOrDefault(iCode,
                    new InjectionStatsDTO(
                    iCode,
                    order.getInjection().getI_name(),
                    0
            ));
            stats.setTotalCount(stats.getTotalCount() + 1);
            statsMap.put(iCode, stats);
        }

        return new ArrayList<>(statsMap.values());
    }

}
