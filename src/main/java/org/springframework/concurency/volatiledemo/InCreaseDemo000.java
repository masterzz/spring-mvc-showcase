package org.springframework.concurency.volatiledemo;

public class InCreaseDemo000 {
    static volatile int m=0;

    public synchronized static void increase(){
        m++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                        increase();
                }
            }).start();
        }//0，分析为什么是0,加了synchronize之后
//        Thread.sleep(20);
        System.out.println(m);
    }
}
