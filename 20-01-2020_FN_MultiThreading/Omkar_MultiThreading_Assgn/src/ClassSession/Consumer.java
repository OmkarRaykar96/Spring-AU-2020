package ClassSession;

public class Consumer implements Runnable {

  public void run(){
    while(true){
      synchronized (Flipkart.inventory){
        if(!Flipkart.inventory.isEmpty()){
          System.out.println(Thread.currentThread().getName()+" "
            +Flipkart.inventory.remove(0));
          Flipkart.inventory.notify();
          try {
            Thread.sleep(1000);
          } catch (Exception e){
            System.out.println(e);
          }
        } else {
          try{
            Flipkart.inventory.wait();
          } catch ( InterruptedException e){
            System.out.println(e);
          }
          System.out.println(Thread.currentThread().getName()+" I have been notified");
        }
      }
    }
  }
}
