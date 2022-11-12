public class SynchronizeThread {
    int i=0;
    synchronized void counter(){
        i++;
        System.out.println(i);
    }
}

class thread1 extends SynchronizeThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter();
        }
    }
}

class thread2 extends SynchronizeThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter();
        }
    }
}

class synchronizedthread_exe{
    public static void main(String[] args) throws InterruptedException {
        thread1 t1 = new thread1();
        thread2 t2 = new thread2();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        
        tt1.start();
        tt2.start();
    }
}