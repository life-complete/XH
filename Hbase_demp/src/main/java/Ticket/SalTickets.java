package Ticket;

public class SalTickets  implements  Runnable{
    private int nums=20;
    @Override
    public synchronized void run() {
        while (true){
                if (nums>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出了"+(nums--));
                }
                else{
                    break ;
                }
            }
        }

}
