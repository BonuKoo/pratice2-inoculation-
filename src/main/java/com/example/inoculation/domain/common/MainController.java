package com.example.inoculation.domain.common;

import com.example.inoculation.domain.cust.Cust;
import com.example.inoculation.domain.cust.dto.CustDTO;
import com.example.inoculation.domain.cust.repository.CustRepository;
import com.example.inoculation.domain.cust.service.CustService;
import com.example.inoculation.domain.injection.Injection;
import com.example.inoculation.domain.injection.dto.InjectionStatsDTO;
import com.example.inoculation.domain.injection.repository.InjectionRepository;
import com.example.inoculation.domain.order.Order;
import com.example.inoculation.domain.order.dto.OrderDTO;
import com.example.inoculation.domain.order.dto.OrderListDTO;
import com.example.inoculation.domain.order.repository.OrderRepository;
import com.example.inoculation.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CustRepository custRepository;
    @Autowired
    private InjectionRepository injectionRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustService custService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/cust")
    public String getCustPage(Model model){
        List<CustDTO> custList = custService.getCustList();
        model.addAttribute("list",custList);
        return "cust";
    }

    @GetMapping("/order")
    public String getInputOrderPage(Model model) {
        String lastSenoNo = orderRepository.getLastSenoNo();
        String lastSenoNoFormat = String.valueOf(Integer.parseInt(lastSenoNo) + 1);
        model.addAttribute("nextNo", lastSenoNoFormat);
        model.addAttribute("orderDTO", new OrderDTO());
        return "order";
    }
    @PostMapping("/regist")
    public String registOrder(@ModelAttribute OrderDTO orderDTO){

        Order order = new Order();
        order.setP_seno(orderDTO.getP_seno());
        order.setCust(custRepository.findById(orderDTO.getCust()).orElse(null));
        order.setInjection(injectionRepository.findById(orderDTO.getInjection()).orElse(null));
        order.setP_date(orderDTO.getP_date());
        orderRepository.save(order);
        return "index";
    }

    @GetMapping("/orderList")
    public String getOrderListPage(Model model) {
        List<OrderListDTO> orderList = orderService.getAllOrders();
        model.addAttribute("list", orderList);
        return "orderList";
    }
    @GetMapping("/injection")
    public String getInjectionStatsPage(Model model) {
        List<InjectionStatsDTO> injectionList = orderService.getInjectionStats();
        model.addAttribute("injectionList", injectionList);
        return "injection";
    }
}
