import java.util.*;

public class Farmer implements Runnable{

	static String[] rndm_fruit = {"empty","Apple","Orange","Grape","WaterMelon"};
	
	@Override
	public void run() {
		while(true) {
			//Getting the type of fruit the farmer will produce
			String name = Thread.currentThread().getName();
			
			int n = name.length();
			char c= name.charAt(n-1);
			int index = Integer.parseInt(String.valueOf(c));
			
			String currFruit=rndm_fruit[index];
					
			//Producing the fruit if stock is not full (i.e. 10)
			synchronized(FruitMarket.Fruits) {
				if(FruitMarket.Fruits.get(currFruit) <10 || !(FruitMarket.Fruits.containsKey(currFruit)))
				{
					int value=0;
					
					if(FruitMarket.Fruits.get(currFruit) == null) {
						FruitMarket.Fruits.put(currFruit,1);
					}
					else {
						value = FruitMarket.Fruits.get(currFruit);
						FruitMarket.Fruits.put(currFruit,(value+1));											
					}
					
					System.out.println(Thread.currentThread().getName()+" has added a "+ currFruit +" to the market's stock!");
					
					
					System.out.println("\nMarket Stock: \n" + new Utility().showStock() + "\n-----------------");
					
					//Manipulating Priority to have nearly equal number of all fruits in the market 
					if(value<3) {
						Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
					}
					else if(value>=3 && value<=5) {
						Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
					}
					else if(value>5) {
						Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
					}
					
					
					FruitMarket.Fruits.notifyAll();
					try {
						Thread.currentThread().sleep(2000);
					}catch(Exception e) {
						System.out.println(e);
					}	
				}
				else {
					try{
						FruitMarket.Fruits.wait();
			          } catch ( InterruptedException e){
			            System.out.println(e);
			          }
				}
			}
		}
	}
}