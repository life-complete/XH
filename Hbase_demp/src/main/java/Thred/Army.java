package Thred;

public class Army implements Runnable {
    //volatile 保证了线程可以正确读取其他线程写入的值
    volatile boolean  keepalived =true;
    @Override
    public void run() {

        while(keepalived){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"进攻对方"+i);
               //让出处理器时间
                Thread.yield();
            }
        }
    }
}
