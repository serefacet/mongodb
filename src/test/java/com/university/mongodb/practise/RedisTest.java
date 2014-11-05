package com.university.mongodb.practise;

import static org.junit.Assert.*;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * redis-cli komutlari
 * config get databases ile database ler gozukur. (2.4 versiyonundan sonrasi icin)
 * keys * ile o db'deki keys'ler gozukur
 * select 1 ile 1 numaralı db'ye gidilir.Totalde 16 database vardir onu redis.conf'dan
 * degistirebilirsin.
 * @author seref
 *
 */
public class RedisTest{

	@Test
	public void connect()
	{
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
		Jedis jedis = pool.getResource();
		
		jedis.select(7);
		jedis.set("comodo", "fenerbahce");
		
		assertTrue(jedis.get("comodo").equals("fenerbahce"));
		
		pool.returnResource(jedis);
		pool.destroy();
	}
}
