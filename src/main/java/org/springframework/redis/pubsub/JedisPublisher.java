package org.springframework.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
public class JedisPublisher {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxWaitMillis(60 * 1000);
        config.setMaxIdle(50);
//        config.setTestOnBorrow(true);
        config.setTestOnBorrow(true);
        config.setMinIdle(20);
        config.setMaxTotal(200);
        jedisPool = new JedisPool(config, "192.168.154.128");
    }

    public static void main(String[] args) {
//        JedisPool jedisPool = new JedisPool("192.168.154.128", 6379);
        Jedis jedis = jedisPool.getResource();
        Long publish = jedis.publish("channel1", "dsfd");
        System.out.println(publish);
    }

    public static void testJedisSet() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set("hello", "world");

            jedis.hset("stu", "name", "xavier");
            jedis.hset("stu", "age", "23");

            jedis.lpush("myList", "1", "2", "3");

            jedis.sadd("names", "xavier", "john", "tom");

            jedis.zadd("scoreboard", 99, "xavier");
            Map<String, Double> scoreboard = new HashMap<>();
            scoreboard.put("tom", 100.0);
            scoreboard.put("john", 101.0);
            jedis.zadd("scoreboard", scoreboard);
        }
    }

    public static void testJedisGet() {
        try (Jedis jedis = jedisPool.getResource()) {
            String hello = jedis.get("hello");
            System.out.println(hello);

            Map<String, String> stu = jedis.hgetAll("stu");
            System.out.println(stu);

            List<String> list = jedis.lrange("myList", 0, -1);
            System.out.println(list);

            Set<String> names = jedis.smembers("names");
            System.out.println(names);

            Set<String> scoreboard = jedis.zrange("scoreboard", 0, -1);
            Set<String> score = jedis.zrangeByScore("scoreboard", 80, 100);
            System.out.println(scoreboard);
            System.out.println(score);
        }
    }
}
