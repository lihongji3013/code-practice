package thread;

/**
 * @Author: hongji
 * @Date: 2021-12-08 10:32
 */
public class DeadLock {
    final static Object lock1 = new Object();
    final static Object lock2 = new Object();
    final static Object lock3 = new Object();


    public static void main(String[] args) {
        Lock1Test lock1Test = new Lock1Test();
        Lock2Test lock2Test = new Lock2Test();

        Thread thread1 = new Thread(lock1Test);
        Thread thread2 = new Thread(lock2Test);
        thread1.start();
        thread2.start();

    }
}

class Lock1Test implements Runnable {
    @Override
    public void run() {
        while (true){
            synchronized (DeadLock.lock1){
                System.out.println("Lock1Test 持有 lock1 锁=====================");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.lock2){
                    System.out.println("Lock1Test 持有 lock2 锁=====================");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Lock2Test implements Runnable {
    @Override
    public void run() {
        while (true){
            synchronized (DeadLock.lock2){
                System.out.println("Lock2Test 持有 lock2 锁=====================");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.lock1){
                    System.out.println("Lock2Test 持有 lock1 锁=====================");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
