package org.springframework.concurency.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/2 16:36 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class Cas2 {
    private static volatile int m = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);


    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            atomicInteger.compareAndSet(100, 110);
            System.out.println(atomicInteger.get());
        });

        thread1.start();
        ;

        Thread thread2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(110, 100);
            System.out.println(atomicInteger.get());
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(100, 120);
            System.out.println(atomicInteger.get());
        });
        thread3.start();

        System.out.println("=====================");

        Thread tf1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(100,110,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1));
        });
    }
}
