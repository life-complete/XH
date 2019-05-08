package Ticket;

public class Demo  {
    public static void main(String[] args) {
        SalTickets salTickets=new SalTickets();
        Thread thread=new Thread(salTickets,"A");
        Thread thread2=new Thread(salTickets,"B");
        Thread thread3=new Thread(salTickets,"c");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
