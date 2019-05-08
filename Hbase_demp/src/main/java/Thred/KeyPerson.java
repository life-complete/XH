package Thred;

public class KeyPerson extends  Thread {
    @Override
    public void run() {
        System.out.println("程咬金开始了战斗");
        for(int i=0;i<3;i++){
            System.out.println("三板斧第"+i+"斧");
        }
        System.out.println("两军战斗结束了");
    }
}
