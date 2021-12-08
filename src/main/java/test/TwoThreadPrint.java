package test;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: hongji
 * @Date: 2021-12-06 11:40
 */
public class TwoThreadPrint {
    static Thread t1,t2;


    public static void main(String[] args) {
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 65 ;i<=90 ;i++){
                    System.out.print((char)i);
                    LockSupport.unpark(t2);
                    LockSupport.park();

                }

            }
        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                for(int i = 1 ;i<=26 ;i++){
                    System.out.print(i);
                    LockSupport.unpark(t1);
                    LockSupport.park();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
