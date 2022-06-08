package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthData = sdf.parse(sc.next());
		
		Client client = new Client(nameClient, email, birthData);
		

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order? ");
		int totalOrder = sc.nextInt();
		
		for(int i=1; i <= totalOrder; i++) {
			System.out.println("Enter #"+i+" item data: ");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			Product product = new Product(name, price);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			OrderItem items = new OrderItem(quantity, price, product);

			order.addItems(items);
		}
		
		System.out.print("\n");
		System.out.print(order);
		

		sc.close();
	}
}
