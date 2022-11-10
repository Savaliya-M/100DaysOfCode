import java.lang.Thread;
class even extends Thread {
    public void run(){
        try {
            System.out.println("even");
                for (int i = 1; i <= 10 ; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }
}
class odd extends Thread{
    public void run(){
        try {
            System.out.println("odd");
            for (int i = 0; i <= 10 ; i++) {
                if(i%2 != 0) {
                    System.out.println(i);
                }
            }
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class Threadpriority{
    public static void main(String[] args) {
        even t1 = new even();
        odd t2 = new odd();

        t1.setName("even");
        t2.setName("odd");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}