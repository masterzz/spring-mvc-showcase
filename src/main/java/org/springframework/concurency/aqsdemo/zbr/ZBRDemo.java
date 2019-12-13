package org.springframework.concurency.aqsdemo.zbr;

import java.util.concurrent.TimeUnit;

public class ZBRDemo {
    ZBRLock zbrLock = new ZBRLock();
    private volatile int m = 0;
//    实现多线程调用这个不会出现重复，并且有顺序
    public int next() {
        try {
            if(m == 2) {
                TimeUnit.SECONDS.sleep(5);
            }
            zbrLock.lock();
//            TimeUnit.SECONDS.sleep(1);
            return m++;
        } catch (Exception e) {
            throw new RuntimeException("Error");
        } finally {
            zbrLock.unlock();
        }
    }

    public static void main(String[] args) {
        ZBRDemo demo = new ZBRDemo();
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(()->{
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(demo.next());
            });
            threads[i].start();
        }
    }
}
