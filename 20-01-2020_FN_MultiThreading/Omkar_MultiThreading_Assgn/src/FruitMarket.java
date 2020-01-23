import java.util.*;

public class FruitMarket {
	
	public static Map<String,Integer> Fruits = new HashMap<>();

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Fruit Market !!!\n");
		
		Fruits.put("Apple",0);
		Fruits.put("Orange",0);
		Fruits.put("Grape",0);
		Fruits.put("WaterMelon",0);
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		
		//USING LAMBDA FUNCTION TO INITIALIZE THREADS
		list.forEach(item->{
			new Thread(new Customer(), "Customer_No_" + item).start();
			new Thread(new Farmer(),"Farmer_No_" + item).start();
		});
	}
}
