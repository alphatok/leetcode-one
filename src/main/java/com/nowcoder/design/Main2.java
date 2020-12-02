package com.nowcoder.design;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class Main2 {

    private static boolean odd = true;
    private final static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) throws  InterruptedException {
        // Thread a
        Thread finalThread2 = null;
        Thread finalThread1 = null;
        finalThread1 = new Thread(() -> {
            while (count.get() < 100) {
                if (!odd) {
                    LockSupport.park(finalThread2);
                }
                System.out.println(count.getAndIncrement());
                odd = !odd;
                LockSupport.unpark(finalThread1);
            }
        });
        finalThread1.start();

        // Thread b
        finalThread2 = new Thread(() -> {
            while (count.get() <= 100) {
                if (odd) {
                    LockSupport.park(finalThread1);
                }

                System.out.println(count.getAndIncrement());
                odd = !odd;
                LockSupport.unpark(finalThread2);
            }
        });
        finalThread2.start();
    }
}
