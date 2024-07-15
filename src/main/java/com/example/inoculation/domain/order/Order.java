package com.example.inoculation.domain.order;

import com.example.inoculation.domain.cust.Cust;
import com.example.inoculation.domain.injection.Injection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_order_01")
@Entity
public class Order {

    //예방접종 이력번호
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(nullable = false,length = 4)
    private Long p_seno;

    //고객번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_no",referencedColumnName = "p_no")
    private Cust cust;

    //백신코드
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_code",referencedColumnName = "i_code")
    private Injection injection;

    //접종일자
    private String p_date;
}
