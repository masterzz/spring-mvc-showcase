package org.springframework.concurency.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/2 15:15 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class Cas1 {
    private static volatile int m = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increase1() {
        m++;
    }

    public static void increase2() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String args[]) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] =
                    new Thread(()->{
                        for (int j = 0; j < 101; j++) {
                            increase1();
                        }
                    });
            threads[i].start();
        }

        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }
//        Thread.sleep(20);
        System.out.println(m);
        increase2();
        System.out.println(atomicInteger.get());

    }
}
