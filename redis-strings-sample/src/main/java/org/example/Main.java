package org.example;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
            try (Jedis jedis = jedisPool.getResource()) {
                /*
                jedis.set("users:300:email", "kim@gmail.com");
                jedis.set("users:300:name", "kim minsu");
                jedis.set("users:300:age", "20");

                String userEmail= jedis.get("users:300:email");
                System.out.println(">> userEmail : " + userEmail);

                List<String> userInfo = jedis.mget("users:300:email", "users:300:name", "users:300:age");
                userInfo.forEach(System.out::println);
                 */

                /*
                 long counter = jedis.incr("counter");
                 System.out.println("counter : " + counter);

                 counter = jedis.incrBy("counter", 10L);
                 System.out.println("counter : " + counter);

                 long counter = jedis.decr("counter");
                 System.out.println("counter : " + counter);

                 counter = jedis.decrBy("counter", 10L);
                 System.out.println("counter : " + counter);
                 */

                Pipeline pipelined = jedis.pipelined();
                pipelined.set("users:400:email", "lee@gmail.com");
                pipelined.set("users:400:name", "lee@gmail.lee jin su");
                pipelined.set("users:400:email", "30");
                List<Object> objects = pipelined.syncAndReturnAll();
                objects.forEach(i -> System.out.println(i.toString()));
            }
        }
    }

}