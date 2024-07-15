package com.example.inoculation.domain.injection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tbl_injection_01")
@Entity
public class Injection {
    
    //백신코드
    @Id @Column(nullable = false, length = 4)
    private String i_code;
    //백신명
    @Column(length = 20)
    private String i_name;
    //연령대
    @Column(length = 20)
    private String i_age;

}
