package com.example.inoculation.domain.cust.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class CustDTO{
    //고객번호
    private String p_no;
    //고객명
    private String p_name;
    //생년월일
    private String p_bday;
    //성별
    private String gender;
    //전화번호
    private String phone;
    //지역
    private String p_city;
    //나이
    private int age;
}

//getter 없으니까 타임리프에 담기질 않는다.