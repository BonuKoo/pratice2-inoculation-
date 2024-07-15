package com.example.inoculation;

import com.example.inoculation.domain.cust.Cust;
import com.example.inoculation.domain.cust.repository.CustRepository;
import com.example.inoculation.domain.injection.Injection;
import com.example.inoculation.domain.injection.repository.InjectionRepository;
import com.example.inoculation.domain.order.Order;
import com.example.inoculation.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class InoculationApplication implements CommandLineRunner {


	@Autowired
	CustRepository custRepository;
	@Autowired
	InjectionRepository injectionRepository;
	@Autowired
	OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(InoculationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cust cust1 = new Cust("1001","김고객","19850301","M","010","2222","0001","10");
		Cust cust2 = new Cust("1002","이고객","19900301","M","010","2222","1002","20");
		Cust cust3 = new Cust("1003","박고객","19770301","F","010","2222","1003","30");
		Cust cust4 = new Cust("1004","조고객","19650301","F","010","2222","1004","10");
		Cust cust5 = new Cust("1005","황고객","19400301","M","010","2222","1005","40");
		Cust cust6 = new Cust("1006","양고객","19440301","F","010","2222","1006","40");
		Cust cust7 = new Cust("1007","허고객","19760301","F","010","2222","1007","10");
		custRepository.saveAll(Arrays.asList(cust1,cust2,cust3,cust4,cust5,cust6,cust7));
		

		Injection injection1 = new Injection("A001","A형간염","19~34세");
		Injection injection2 = new Injection("A002","TD백신","40~49세");
		Injection injection3 = new Injection("A003","인플루엔자","50~64세");
		Injection injection4 = new Injection("A004","폐렴사슬알균","65세 이상");
		injectionRepository.saveAll(Arrays.asList(injection1,injection2,injection3,injection4));

		Order order1 = new Order(20200001L,cust1,injection1,"20200101");
		Order order2 = new Order(20200002L,cust2,injection1,"20200102");
		Order order3 = new Order(20200003L,cust3,injection1,"20200103");
		Order order4 = new Order(20200004L,cust4,injection1,"20200104");
		Order order5 = new Order(20200005L,cust5,injection1,"20200105");
		Order order6 = new Order(20200006L,cust6,injection1,"20200106");
		Order order7 = new Order(20200007L,cust7,injection1,"20200107");
		Order order8 = new Order(20200008L,cust5,injection1,"20200108");
		Order order9 = new Order(20200009L,cust6,injection1,"20200109");
		//Order order10 = new Order(20200010L,cust1,injection1,"202001010");
		orderRepository.saveAll(Arrays.asList(order1,order2,order3,order4,order5,order6,order7,order8,order9));
	}
}
