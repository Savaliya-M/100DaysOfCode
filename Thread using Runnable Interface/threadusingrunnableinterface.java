class neweven implements Runnable {
    public void run(){
        try {
            System.out.println("even");
            for (int i = 1; i <= 10 ; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class newodd implements Runnable{
    public void run(){
        try {
            System.out.println("odd");
            for (int i = 0; i <= 10 ; i++) {
                if(i%2 != 0) {
                    System.out.println(i);
                }
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class threadusingrunnableinterface {
    public static void main(String[] args) {
        neweven t1 = new neweven();
        newodd t2 = new newodd();

        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);

        tt1.setPriority(Thread.MIN_PRIORITY);

        tt1.start();
        tt2.start();
    }
}
