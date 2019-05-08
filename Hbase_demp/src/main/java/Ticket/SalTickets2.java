package Ticket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SalTickets2 implements  Runnable{
    private int nums=20;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
                if (nums>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出了"+(nums--));
                }
                else{
                    break ;
                }
            lock.unlock();

        }

    }
}
