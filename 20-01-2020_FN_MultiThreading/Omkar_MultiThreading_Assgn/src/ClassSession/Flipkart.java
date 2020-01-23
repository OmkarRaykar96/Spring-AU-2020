package ClassSession;

import java.util.ArrayList; 
import java.util.List;

public class Flipkart {

  public static List<Integer> inventory = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("I'm Flipkart");
    
    Thread producer = new Thread(new Producer(), "Producer");
    
    for(int i=1;i<=3;i++){
      new Thread(new Consumer(), "Consumer_" + i).start();
    }

    producer.start();

  }

}
