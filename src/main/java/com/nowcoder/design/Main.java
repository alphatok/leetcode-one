package com.nowcoder.design;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static boolean odd = true;
    private final static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) throws  InterruptedException {
        // Thread a
        new Thread(() -> {
            while(count.get() <= 100){ // todo
                synchronized(count){
                    if (!odd){
                        try {
                            count.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(count.getAndIncrement());
                    count.notify();
                    odd = !odd;
                }
            }
        }).start();

        Thread.sleep(1000000000);

        // Thread b
        new Thread(() -> {
            while(count.get() <=100){
                synchronized(count){
                    try {
                        if (odd){
                            count.wait();
                        }

                        System.out.println(count.getAndIncrement());
                        odd = !odd;
                        count.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
