package com.ComponentesEInjecao.ComponentesInjecao;

import com.ComponentesEInjecao.ComponentesInjecao.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ComponentesEInjecao.ComponentesInjecao.entities.Order;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentesInjecaoApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(ComponentesInjecaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code,basic, discount);

		double total = orderService.total(order);


		System.out.println();
		System.out.printf("Pedido código %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f%n", total);

		sc.close();
	}
}
