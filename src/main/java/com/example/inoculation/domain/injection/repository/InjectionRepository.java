package com.example.inoculation.domain.injection.repository;

import com.example.inoculation.domain.injection.Injection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InjectionRepository extends JpaRepository<Injection,String> {

}
