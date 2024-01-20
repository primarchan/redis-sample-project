package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (Jedis jedis = jedisPool.getResource()) {
                jedis.rpush("stack1", "aaa");
                jedis.rpush("stack2", "bbb");
                jedis.rpush("stack3", "ccc");

                List<String> stack1 = jedis.lrange("stack1", 0, -1);
                stack1.forEach(System.out::println);

                System.out.println();
            }
        }
    }

}