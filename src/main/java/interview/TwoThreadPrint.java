package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hongji
 * @Date: 2020-10-15 17:05
 */
public class TwoThreadPrint {


    private static ReentrantLock lock = new ReentrantLock();
    private static Condition aCondition = lock.newCondition();
    private static Condition bCondition = lock.newCondition();

    public static void main(String[] args) {
        long threadStart = System.currentTimeMillis();

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                long thread1CurrentTimeMill = System.currentTimeMillis();
                char a = 'a';
                char b = (char) (a + 26);
                while (a < b) {
                    lock.lock();
                    try {
                        for (int i = 0; i < 26; i++) {
                            System.out.print(a);
                            a++;
                            bCondition.signal();
                            aCondition.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
                System.out.println();
                System.out.println(String.format("thread1本次打印耗时：%s ms",System.currentTimeMillis()-thread1CurrentTimeMill));
            }
        };

        thread1.setName("小写字母线程");
        Thread thread2 = new Thread() {
             volatile long thread2CurrentTimeMill = System.currentTimeMillis();
            @Override
            public void run() {
                char A = 'A';
                char B = (char) (A + 26);
                while (A < B) {
                    lock.lock();
                    try {
                        for (int i = 0; i < 26; i++) {
                            System.out.print(A);
                            A++;
                            aCondition.signal();
                            bCondition.await();
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }finally {
                        lock.unlock();

                    }
                    System.out.println();
                    System.out.println(String.format("thread2本次打印耗时：%s ms",System.currentTimeMillis()-thread2CurrentTimeMill));

                }

            }
        };
        thread2.setName("大写字母线程");
        thread1.start();
        thread2.start();
        System.out.println(String.format("两个打印耗时：%s ms",System.currentTimeMillis()-threadStart));
    }
}
