import java.util.Random;


public class Customer implements Runnable {

	static String[] rndm_fruit = {"Apple","Orange","Grape","WaterMelon"};
	
	@Override
	public void run() {
		while(true) {
			String customerName = Thread.currentThread().getName();
			int index = new Random().nextInt(5)%4;
			
			String currFruit= rndm_fruit[index];
			
			
			synchronized(FruitMarket.Fruits) {
				if(FruitMarket.Fruits.containsKey(currFruit) && FruitMarket.Fruits.get(currFruit)>0)
				{	
					int value = FruitMarket.Fruits.get(currFruit);
					FruitMarket.Fruits.put(currFruit,(value-1));
					
					//For Red & Black Output
					System.err.println(customerName+" has bought a "+ currFruit +" from the market!"+"\n"
							+ "\nMarket Stock: "+ new Utility().showStock() + "\n-----------------");
					
					
					//Manipulating Priority to make sure all customers get a chance to buy fruits
					if(value<3) {
						Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
					}
					else if(value>=3 && value<=5) {
						Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
					}
					else if(value>5) {
						Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
					}
					
					FruitMarket.Fruits.notifyAll();	
					try {
						Thread.currentThread().sleep(1000);
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