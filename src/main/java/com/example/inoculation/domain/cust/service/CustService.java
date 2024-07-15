package com.example.inoculation.domain.cust.service;

import com.example.inoculation.domain.cust.Cust;
import com.example.inoculation.domain.cust.dto.CustDTO;
import com.example.inoculation.domain.cust.repository.CustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustService {

    @Autowired
    private CustRepository custRepository;

    public List<CustDTO> getCustList(){

        List<Cust> list = custRepository.findAll();
        DateTimeFormatter inputFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

        LocalDate baseYear2000 = LocalDate.of(2000,1,1);

        return list.stream()
                .map(cust -> {

                    LocalDate birthDate = birthDateFormatToInputFormatter(cust, inputFormatter);
                    String formattedBirthDate = formatToKoreanDateForm(birthDate, outputFormatter);

                    int age = Period.between(birthDate, baseYear2000).getYears();

                    String gender = cust.getP_gender().equals("M") ? "남" : "여";

                    String phone = String.format("%s-%s-%s", cust.getP_tel1(), cust.getP_tel2(), cust.getP_tel3());
                    String region = regionSwitch(cust.getP_city());
                    //고객번호, 고객명, 생년월일, 성별, 전화번호, 지역,나이
                    return new CustDTO(cust.getP_no(), cust.getP_name(), formattedBirthDate, gender, phone, region, age);
                })
                .collect(Collectors.toList());
    }


    private static LocalDate birthDateFormatToInputFormatter(Cust cust, DateTimeFormatter inputFormatter) {
        return LocalDate.parse(cust.getP_bday(), inputFormatter);
    }

    private static String formatToKoreanDateForm(LocalDate birthDate, DateTimeFormatter outputFormatter) {
        return birthDate.format(outputFormatter);
    }
    private String regionSwitch(String regionCode){
        switch (regionCode){
            case "10":
                return "서울";
            case "20":
                return "경기";
            case "30":
                return "강원";
            case "40":
                return "대구";
        }
        return regionCode;
    }
    
}
