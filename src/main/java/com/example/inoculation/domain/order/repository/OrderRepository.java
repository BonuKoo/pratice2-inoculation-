package com.example.inoculation.domain.order.repository;

import com.example.inoculation.domain.injection.dto.InjectionStatsDTO;
import com.example.inoculation.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    @Query("SELECT MAX(o.p_seno) from Order o")
    String getLastSenoNo();

    /*
    오류
    @Query("SELECT new com.example.inoculation.domain.injection.dto.InjectionStatsDTO(" +
            "i.i_code, i.i_name, COUNT(o)) " +
            "FROM Order o " +
            "JOIN o.injection i " +
            "GROUP BY i.i_code, i.i_name")
    List<InjectionStatsDTO> findInjectionStats();

     */
}
