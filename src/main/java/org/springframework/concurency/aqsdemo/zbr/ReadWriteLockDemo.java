package org.springframework.concurency.aqsdemo.zbr;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：ReentrantReadWriteLock
 * 独占锁/共享锁
 * 独占锁：同一时间内只允许一个线程持有该锁，保证数据一致性，Synchronized/ReentrantLock都是独占锁
 * 共享锁：同一时间内允许多个线程持有该锁，多个线程可以操作
 * 读写锁：写操作是独占锁，读操作是共享锁，写独占保证数据一致性，读共享保证并发性
 * 就好比一个成绩单需要签名，但是又可以供多个人一起读，此时同一时间内签名只允许一个人进行操作，而看成绩单可以多个人一起看
 *
 */
public class ReadWriteLockDemo {

    public static void main(String[] args){

        Myche myche = new Myche();

        //5个写线程进行写操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myche.writeMap(String.valueOf(tempInt), tempInt);
                }
            }, String.valueOf(i)).start();
        }
        //5个读线程进行读操作
        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myche.readMap(String.valueOf(tempInt));
                }
            }, String.valueOf(i)).start();
        }
    }

}

//未加锁
//资源类（多线程编程，线程操作资源类，保证高内聚，低耦合）
//class Myche{
//    //手写一个缓存类（包含三步：写入，读取，清空缓存）
//    //volatile保证可读性（及时性），不保证原子性，进制指令重排
//    private volatile Map<String,Object> map = new HashMap<>();
//
//    //写入
//    public void writeMap(String key,Object value){
//        System.out.println(Thread.currentThread().getName() + "\t 正在写入...");
//        //暂停一会当前线程，模拟网络拥堵
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        map.put(key, value);
//        System.out.println(Thread.currentThread().getName() + "\t 写入完成...");
//    }
//
//    //读取
//    public void readMap(String key) {
//        System.out.println(Thread.currentThread().getName() + "\t 正在读取......");
//        // 暂停一会当前线程，模拟网络拥堵
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Object result = map.get(key);
//        System.out.println(Thread.currentThread().getName() + "\t 读取完成......" + result);
//    }
//
//    //清除缓存，这里不需要，就不写了
//	/*public void clearMap(){
//		map.clear();
//	}*/
//
//}

//资源类（多线程编程，线程操作资源类，保证高内聚，低耦合）
//class Myche{
//    //手写一个缓存类（包含三步：写入，读取，清空缓存）
//    //volatile保证可读性（及时性），不保证原子性，进制指令重排
//    private volatile Map<String,Object> map = new HashMap<>();
//    private Lock lock = new ReentrantLock();
//    //写入
//    public void writeMap(String key,Object value){
//        lock.lock();
//        try{
//            System.out.println(Thread.currentThread().getName() + "\t 正在写入...");
//            //暂停一会当前线程，模拟网络拥堵
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            map.put(key, value);
//            System.out.println(Thread.currentThread().getName() + "\t 写入完成...");
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            lock.unlock();
//        }
//
//    }
//
//    //读取
//    public void readMap(String key) {
//        lock.lock();
//        try{
//            System.out.println(Thread.currentThread().getName() + "\t 正在读取......");
//            // 暂停一会当前线程，模拟网络拥堵
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            Object result = map.get(key);
//            System.out.println(Thread.currentThread().getName() + "\t 读取完成......" + result);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally{
//            lock.unlock();
//        }
//
//    }
//
//    //清除缓存，这里不需要，就不写了
//	/*public void clearMap(){
//		map.clear();
//	}*/
//
//}

//资源类（多线程编程，线程操作资源类，保证高内聚，低耦合）
class Myche{
    //手写一个缓存类（包含三步：写入，读取，清空缓存）
    //volatile保证可读性（及时性），不保证原子性，进制指令重排
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //写入
    public void writeMap(String key,Object value){
        lock.writeLock().lock();//写锁，独占锁
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在写入...");
            //暂停一会当前线程，模拟网络拥堵
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成...");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.writeLock().unlock();
        }

    }

    //读取
    public void readMap(String key) {
        lock.readLock().lock();//读锁，共享锁
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在读取......");
            // 暂停一会当前线程，模拟网络拥堵
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成......" + result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.readLock().unlock();
        }

    }

    //清除缓存，这里不需要，就不写了
	/*public void clearMap(){
		map.clear();
	}*/

}