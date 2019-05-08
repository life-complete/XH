package Thred;

public class Stage extends  Thread{
    @Override
    public void run() {
        Army Tang=new Army();
        Army Sui=new Army();
        Thread thread=new Thread(Tang,"唐军");
        Thread thread1=new Thread(Tang,"隋军");
        thread.start();
        thread1.start();
        try {
            Thread.sleep(2000);
            //舞台线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Tang.keepalived=false;
        Sui.keepalived=false;
        Thread cheng=new KeyPerson();
        cheng.setName("程咬金");
        System.out.println("程咬金想要结束战斗");
        cheng.start();
        try {
            cheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            new Stage().start();
    }
}
