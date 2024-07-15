package com.example.inoculation.domain.injection.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class InjectionStatsDTO {

    //백신코드
    private String i_code;
    //백신명
    private String i_name;
    //백신별 총 건수
    private long totalCount;
}
