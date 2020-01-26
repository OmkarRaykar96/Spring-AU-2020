package com.hibernate.controller;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.model.*;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);																											Scanner sd = new Scanner(System.in);Scanner se = new Scanner(System.in);Scanner sf = new Scanner(System.in);Scanner sg = new Scanner(System.in);Scanner sh = new Scanner(System.in);Scanner si = new Scanner(System.in);Scanner sj = new Scanner(System.in);Scanner sk = new Scanner(System.in);Scanner sl = new Scanner(System.in);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		int home_pin, office_pin; int select = 0;
		String name, email, number, home_street, office_street;

		System.out.println("Name:");						name = sc.next();
		System.out.println("Email:");						email = sd.next();
		System.out.println("Contact No:");					number = se.next();
		System.out.println("Home Address Street:");			home_street = sf.next();
		System.out.println("Home Address Pincode:");		home_pin = sg.nextInt();
		System.out.println("Office Address Street:");		office_street = sh.next();
		System.out.println("Office Address Pincode:");		office_pin = si.nextInt();

		Address home = new Address(home_pin, home_street);
		Address office = new Address(office_pin, office_street);

		do {
			System.out.println("Press the respective key to play the role:\n1. Seller\n2. Buyer\n3. Exit");
			select = sj.nextInt();
			if (select == 1) {
				Seller seller = new Seller(name, number, email, home, office);
				int select_new = 0;
				int sellerId = 0;
				do {
					System.out.println("1. Add a Product \n2. View a Product \n3. Exit");
					select_new = sj.nextInt();
					switch (select_new) {
					case 1:
						System.out.println("Enter Name of the Product:");
						String productName = sk.next();
						System.out.println("Enter Description of the Product:");
						String prodctDesc = sl.next();
						System.out.println("Enter Price of the Product:");
						int price = sj.nextInt();
						Product product = new Product(productName, price, prodctDesc);
						product.setSeller(seller); 
						session.save(product);
						seller.getProductList().add(product);
						sellerId = (Integer) session.save(seller); 
						System.err.println("Product Added");
						session.getTransaction().commit();
						session.beginTransaction();
						break;

					case 2:
						if (sellerId == 0) {
							System.err.println("No Products Added");
						}
						else {
							Seller seller_obj = session.get(Seller.class, sellerId);
							for (Product p : seller_obj.getProductList()) 
								System.out.println(p.toString());
						}
						break;

					case 3:
						System.err.println("Switch!");
						break;
						
					default:
						System.err.println("Incorrect Input");
						break;
					}
				} while (select_new != 3);
			}
			
			else if (select == 2) {
				Buyer buyer = new Buyer(name, number, email, home, office);
				int select_buyer = 0;
				List<Product> selected = new ArrayList<>();
				int pid = 0;
				boolean added = false;
				do {
					System.out.println("1. View Products \n2. View Added product \n3. confirmed orders \n4. Exit");
					select_buyer = sj.nextInt();
					switch (select_buyer) {
					case 1:
						List<Product> products = session.createQuery("from Product", Product.class).list();
						for (Product p : products)
							System.out.println(p.toString());
						System.out.println("1. Purchase Product \n2. Back");
						int select6 = sj.nextInt();
						switch (select6) {
						case 1:
							System.out.println("Enter Product id to add:");
							pid = sj.nextInt();
							selected.addAll(session.createQuery("from Product where productid = " + pid, Product.class).list());
							added = true;
							System.err.println("Product added Successfully!");
							break;
						case 2:
							//Looping Back
							break;
						default:
							System.out.println("Enter Proper option");
						}
						break;
						
					case 2:
						int total = 0;
						if (!added) {
							System.err.println("Empty");
						}
						else {
							for (Product p : selected) {
								System.out.println(p.toString());
								total += p.getPrice();
							}
							System.out.println("1. Confirm Order\n2. Back");
							int select_confirm = sj.nextInt();
							int orderid = 0;
							if (select_confirm == 1) {
								Order order = new Order();
								order.setBuyer(buyer);
								order.setProductList(selected);
								orderid = (Integer) session.save(order); // save order
								session.save(buyer);
								System.out.println(order.toString());
								System.err.println("Order Successful!");
								session.getTransaction().commit();
								session.beginTransaction();
								selected.clear();
								added = false;
							} else if (select_confirm == 2) {
								//Looping back
							}
							else
								System.err.println("Invalid Input");
						}
						break;
					case 3:
						Query query = session.getNamedQuery("GET_ALL_ORDERS");
						List<Order> orders = query.list();

						if (orders.isEmpty())
							System.err.println("No Orders Placed!");
						else {
							for (Order o : orders)
								System.out.println(o.toString());
							System.out.println("1. Delete\n2. Go Back");
							int select5 = sj.nextInt();
							switch (select5) {
							case 1:
								System.out.println("Enter ID of the Order to be Deleted");
								int delete = sj.nextInt();
								Order ord = (Order) session.load(Order.class, delete);
								session.delete(ord);
								System.err.println("Order deleted successfully!");
								session.getTransaction().commit();
								session.beginTransaction();
								break;
								
							case 2:
									//Looping Back
								break;
								
							default:
								System.err.println("Invalid option");
							}
						}
						break;
						
					case 4:
						System.err.println("Exiting...");
						break;
					default:
						System.err.println("Invalid option");
					}
				} while (select_buyer != 4);
			}
			else if (select == 3) {
				System.err.println("Thank you for shopping with us!");
			}
			else {
				System.err.println("Incorrect Input");
			}
		} while (select != 3);
		sc.close();																																						sd.close();se.close();sf.close();sg.close();sh.close();si.close();sj.close();sk.close();sl.close();
	}
}