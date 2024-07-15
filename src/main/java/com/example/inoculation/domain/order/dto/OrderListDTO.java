package com.example.inoculation.domain.order.dto;

import com.example.inoculation.domain.order.Order;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class OrderListDTO {

    private String p_seno;
    private String p_no;
    private String custName;
    private String i_code;
    private String i_name;
    private String p_date;

    public static OrderListDTO fromOrder(Order order) {
        OrderListDTO dto = new OrderListDTO();
        dto.setP_seno(formatP_Seno(order.getP_seno()));
        dto.setP_no(order.getCust().getP_no());
        dto.setCustName(order.getCust().getP_name());
        dto.setI_code(order.getInjection().getI_code());
        dto.setI_name(order.getInjection().getI_name());
        dto.setP_date(formatP_Date(order.getP_date()));
        return dto;
    }
    private static String formatP_Seno(Long p_seno) {
        if (p_seno == null) return "";
        String formatted = String.format("%04d", p_seno);
        return "2020-" + formatted;
    }

    private static String formatP_Date(String p_date) {
        if (p_date == null || p_date.isEmpty()) return "";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(p_date, inputFormatter);
        return date.format(outputFormatter);
    }
}
