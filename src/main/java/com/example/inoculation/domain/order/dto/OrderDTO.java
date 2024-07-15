package com.example.inoculation.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class OrderDTO {
    private Long p_seno;
    private String cust;
    private String injection;
    private String p_date;
}