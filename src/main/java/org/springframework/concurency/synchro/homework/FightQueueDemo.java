package org.springframework.concurency.synchro.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱斌荣
 * @Email zhubr11@chinaunicom.cn
 * @date 2019/12/3 9:26 ;
 * @Description ADDFUNCTION
 * @Reason ADDREASON
 */
public class FightQueueDemo {
    private static List<String> companies = Arrays.asList("东方航空", "南方航空", "北方航空");
    private static List<String> flights = new ArrayList<>();

    public static void main(String[] args) {
        String origin = "北京";
        String dest = "上海";
        Thread[] threads = new Thread[companies.size()];
        CountDownLatch latch = new CountDownLatch(companies.size());
        for (int i = 0; i < companies.size(); i++) {
            String name = companies.get(i);
            threads[i] = new Thread(() -> {
                System.out.printf("%s查询从%s到%s的机票\n",name,origin,dest);
                //随机生成一个机票
                int val = new Random().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flights.add(name+"----" + val);
                latch.countDown();
            },companies.get(i));
            threads[i].start();
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("查询结果如下：============================");
        flights.forEach(System.out::println);
    }

}
