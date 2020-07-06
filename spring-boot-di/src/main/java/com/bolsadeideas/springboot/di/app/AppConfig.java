package com.bolsadeideas.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bolsadeideas.springboot.di.app.models.domain.ItemInvoice;
import com.bolsadeideas.springboot.di.app.models.domain.Product;

@Configuration
public class AppConfig {

	@Bean("list")
	@Primary
	public List<ItemInvoice> registerItems(){
		
		Product product1 = new Product("Camera", 400);
		Product product2 = new Product("Monitor", 200);
		
		ItemInvoice item1 = new ItemInvoice(product1, 2);
		ItemInvoice item2 = new ItemInvoice(product2, 2);
		
		return Arrays.asList(item1, item2);
	}
	
	@Bean("listOffice")
	public List<ItemInvoice> registerItemsOffice(){
		
		Product product1 = new Product("Laptop", 700);
		Product product2 = new Product("hard Drive", 40);
		Product product3 = new Product("Pixel Phone", 250);
		
		ItemInvoice item1 = new ItemInvoice(product1, 2);
		ItemInvoice item2 = new ItemInvoice(product2, 4);
		ItemInvoice item3 = new ItemInvoice(product3, 5);

		return Arrays.asList(item1, item2, item3);
	}
}
