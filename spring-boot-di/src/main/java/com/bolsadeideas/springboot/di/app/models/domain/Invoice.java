package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Invoice implements Serializable {

	private static final long serialVersionUID = -5993675546582732293L;

	@Value("${invoice.description}")
	private String description;
	
	@Autowired
	private Client client;
	
	@Autowired
	@Qualifier("listOffice")
	private List<ItemInvoice> itemInvoiceList;
	
	@PostConstruct
	public void init() {
		System.out.println("Creating invoice");
		description = description
			.concat(client.getName())
			.concat(" ")
			.concat(client.getSurname());
	}
	
	@PreDestroy
	public void onDestroy() {
		System.out.println("Destroying invoice");
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<ItemInvoice> getItemInvoiceList() {
		return itemInvoiceList;
	}
	public void setItemInvoiceList(List<ItemInvoice> itemInvoiceList) {
		this.itemInvoiceList = itemInvoiceList;
	}
}
