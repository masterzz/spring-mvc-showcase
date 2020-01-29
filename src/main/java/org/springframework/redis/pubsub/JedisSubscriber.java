package org.springframework.redis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

public class JedisSubscriber extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + " = " + message);
    }

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
        System.out.println("thread begin");
        jedis.subscribe(new JedisSubscriber(), "channel1");
    }
}
