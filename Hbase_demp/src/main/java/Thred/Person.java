package Thred;

public class Person extends  Thread{
    @Override
    public void run() {
        System.out.println("是正义的一方");
        int count=0;
        boolean keepalive=true;
        while (keepalive){
            System.out.println(getName()+":攻城"+(++count)+"次");
            if(count%10==0){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            if(count==100){
                keepalive=false;
                System.out.println("战斗结束");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread=new Person();
        thread.setName("李世民");
        thread.start();
        Thread thread1=new Thread(new evil());
        thread1.setName("世充");
        thread1.start();
    }
}

class evil implements Runnable{
    @Override
    public void run() {
        System.out.println("是邪恶的一方");
        int count = 0;
        boolean keepalive = true;
        while (keepalive) {
            System.out.println(Thread.currentThread().getName() + ":守城" + (++count) + "次");
            if (count % 10 == 0) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            if (count == 100) {
                keepalive = false;
                System.out.println("防御结束");
            }
        }
    }}

