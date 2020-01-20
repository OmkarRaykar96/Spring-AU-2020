package ECommerce;

public class Product{
	int id;
	String name;
	float price;
	int cart;
	int quantity;
	static int id_counter=1;
	
	Product(String _name,float _price,int _quantity){
		this.id = id_counter++;
		this.name = _name;
		this.price = _price;
		this.cart=0;
		this.quantity=_quantity;
	}
	
	public void addtoCart(){
		cart++;
	}
	
	public void removeFromCart() {
		if(cart == 0) {
			System.out.println("Item not in cart");
		}
		else{
			cart--;
		}
	}
}