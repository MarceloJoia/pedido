package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	Product product = new Product();

	private Date moment;
	private OrderStatus status;

	private Client client;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.setClient(client);
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStsus() {
		return status;
	}

	public void setStsus(OrderStatus stsus) {
		this.status = stsus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}

	public void removeItems(OrderItem item) {
		items.remove(item);
	}

	public double total() {
		double soma = 0.0;
		for (OrderItem item : items) {
			soma += item.subTotal();
		}
		return soma;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append(client + "\n");
		sb.append("Order items:\n");

		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}
