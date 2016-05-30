package com;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

public class RedisTest {
	
	public static void main(String[] args) {
		Jedis jedis =new Jedis("localhost",6379);
		jedis.auth("admin");
		
		jedis.select(1);
		System.out.println(jedis.set("liu", "peng"));
		
		jedis.g
		
		
		Set<String> keys = jedis.keys("*");
//		for (String string : keys) {
//			
//		}
		System.out.println(keys);
		
		System.out.println(jedis.append("liu", "peng"));
		
		System.out.println(jedis.dbSize());
		
		System.out.println(jedis.get("liu"));
		
		
		/**
		 * 事物
		 */
		Transaction multi = jedis.multi();
		for (int i = 0; i < 3; i++) {
			multi.set("t" + i, "t" + i);

		}
		System.out.println(multi.exec());
		
		/*管道技术*/
		Pipeline pipelined = jedis.pipelined();
		System.out.println(pipelined.set("ss", "ss"));
		pipelined.set("ss", "ss");
		System.out.println(pipelined.syncAndReturnAll());
		
		
		 jedis.disconnect();

	}

}
