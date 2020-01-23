package ClassSession;

public class Producer implements Runnable {

  public void run(){
    System.out.println("Producer Thread");

    try {
      Thread.sleep(1000);
    } catch (Exception e){
      System.out.println(e);
    }
    synchronized (Flipkart.inventory){
//      for(int i=0;i<100;i++){
//        Flipkart.inventory.add(i);
//
//      }
      Flipkart.inventory.notifyAll();
      System.out.println(Thread.currentThread().getName()+ " "+ Flipkart.inventory.size());

    }
  }
}
