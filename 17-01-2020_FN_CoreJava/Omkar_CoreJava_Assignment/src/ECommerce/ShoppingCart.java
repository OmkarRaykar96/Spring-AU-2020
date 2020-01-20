package ECommerce;

import java.util.*;

public class ShoppingCart {

	//Storing Objects of Products & Orders
	static HashMap<Integer,Product> productList=new HashMap<Integer,Product>();

	public static HashMap<Integer,String> placedOrders = new HashMap<Integer,String>();
	static int orderID=1;
	static String username="";
		
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner st=new Scanner(System.in);

		System.out.println("Enter your username: ");
		username=st.nextLine();
		
		int select=1;
		
		populateDefaultList();
		
	do {
			System.out.println("-----------------------------------------------------------------------------------\nSelect an option:\n1. Add Product to Cart\n2. Remove Product from Cart\n3. View Cart\n4. PlaceOrder\n5. Cancel Order\n6. Exit");
			select=sc.nextInt();
			switch(select) {
			
		case 1: 
				addToCart(); 		
				break;
		case 2: 
				removeFromCart();
				break;
		case 3: 
				viewCart();
				break;
		case 4: 
				placeOrder();
				break;
		case 5:
				cancelOrder();
				break;
		case 6: 
				System.out.println("-----------------------------------------------------------------------------------\nThank you for shopping with us");
				break;
		default:
				System.out.println("-----------------------------------------------------------------------------------\nIncorrect Option!!!");
				break;
		}
	}while(select!=6);
		
}

public static void addToCart() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("-----------------------------------------------------------------------------------\nSelect a product to add to cart");
		viewProducts();
		
		int ATC=sc.nextInt();
		if(ATC <= productList.size() && ATC > 0) {
			Product temp=productList.get(ATC);
			temp.addtoCart();
			temp.quantity--;
		}
		else {
			System.out.println("Invalid Product ID");
		}
}


public static void removeFromCart() {
	Scanner sc=new Scanner(System.in);
	ArrayList<Integer> list = viewCart();
	
	System.out.println("-----------------------------------------------------------------------------------\nEnter the product ID to remove from cart");
	
	int RFC=sc.nextInt();
	
	if(list.contains(RFC)) {
		Product temp=productList.get(RFC);
		temp.removeFromCart();
		temp.quantity++;
	}
	else {
		System.out.println("Item not in Cart!!!");
	}
}

public static ArrayList<Integer> viewCart(){
	ArrayList<Integer> list=new ArrayList<Integer>();
	boolean flag=false;
	System.out.println("-----------------------------------------------------------------------------------\n");
	for(int i=1;i<=productList.size();i++) {
		Product temp=productList.get(i);
		if(temp.cart > 0) {
			flag=true;
			System.out.println(temp.id +". "+ temp.name+" - Quantity (in Cart): "+temp.cart+" Total Price: "+(temp.cart*temp.price));
			list.add(i);
		}
	}
	if(!flag) {
		System.out.println("Cart is Empty!");
	}
	
	return(list);
}


public static void viewProducts() {
	System.out.println();
	for(int i=1;i<=productList.size();i++) {
		Product temp=productList.get(i);
		System.out.println(i+"."+temp.name+"- Rs."+temp.price+"/- only" + " | Quantity Available= "+ temp.quantity);
	}
}


public static void placeOrder() {
	ArrayList<Integer> checkOut=new ArrayList(viewCart());
	String str="";

	int totalAmount=0;
	
	for(int i=0;i<checkOut.size();i++) {
		Product temp= productList.get(checkOut.get(i));
		totalAmount += (temp.cart*temp.price);
		str += (temp.cart+". "+temp.name+" ");
	}
	
	for(int i=1;i<=productList.size();i++) {
		Product temp= productList.get(i);
		temp.cart=0;
	}
	
	if(totalAmount==0) {
		return;
	}
	
	System.out.println("-----------------------------------------------------------------------------------\n");
	System.out.println("Your Order has been Placed | Cart is now Empty" + " | Final Amount to Pay by the user:" + username +  " is "+ totalAmount);
	
	str=("Order ID: '"+ orderID + "' Placed by -> "+ username + " \nContent: "+str);
	placedOrders.put(orderID++,str);
}


public static void cancelOrder() {
	if(placedOrders.isEmpty()) {
		System.out.println("No Orders Placed!!!");
		return;
	}
	else {
	Scanner sc=new Scanner(System.in);
	placedOrders.forEach((k, v) -> System.out.println(v));
	int ord_id=0;
	
	System.out.println("-----------------------------------------------------------------------------------\n");
	System.out.println("\nSelect the ID of the order to be deleted: ");
	ord_id=sc.nextInt();
	
	if(placedOrders.get(ord_id)!= null) {
		System.out.println("Selected order has been cancelled");
		placedOrders.remove(ord_id);
	}
	else {
		System.out.println("Incorrect Order ID");
	}
}
}

public static void populateDefaultList() {
	Product prod_obj_1 = new Product("One Plus 6",35000,100);
	Product prod_obj_2 = new Product("Samsung Galaxy s10",64000,200);
	Product prod_obj_3 = new Product("iPhone 8",30000,300);
	Product prod_obj_4 = new Product("Nokia 6",16000,250);
	Product prod_obj_5 = new Product("Asus ROG 2",39000,150);
	Product prod_obj_6 = new Product("Oppo F15",19990,90);
	Product prod_obj_7 = new Product("Vivo V17 Pro",27000,500);
	
	productList.put(1,prod_obj_1);
	productList.put(2,prod_obj_2);
	productList.put(3,prod_obj_3);
	productList.put(4,prod_obj_4);
	productList.put(5,prod_obj_5);
	productList.put(6,prod_obj_6);
	productList.put(7,prod_obj_7);
}
}