package com.example.inoculation.domain.cust.repository;

import com.example.inoculation.domain.cust.Cust;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustRepository extends JpaRepository<Cust,String > {
}
