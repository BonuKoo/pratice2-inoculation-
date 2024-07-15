package com.example.inoculation.domain.cust;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "tbl_cust_01")
@Entity
public class Cust {
    //고객번호
    @Id
    @Column(nullable = false,length = 4)
    String p_no;
    //고객명
    @Column(length = 20)
    String p_name;
    //고객생년월일
    @Column(length = 8)
    String p_bday;
    //성별
    @Column(length = 1)
    String p_gender;
    //전화1
    @Column(length = 3)
    String p_tel1;
    //전화2
    @Column(length = 4)
    String p_tel2;
    //전화3
    @Column(length = 4)
    String p_tel3;
    //지역
    @Column(length = 2)
    String p_city;
}
