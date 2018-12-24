package com.ushine.xuexi.redis;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
	//Redis服务器ip
	private static String ADDR = "127.0.0.1";
	
	//Redis的端口号
	private static int PORT = 6379;
	
	//可以连接实例的最大数目，默认值是8
	//如果赋值为-1则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时的pool的状态为exhausted（耗尽）
	private static int MAX_ACTIVE = 1024;
	
	//控制一个pool最多有多少个状态为idle（空闲的）的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;
	
	//等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;
	
	//在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON＿BORROW = true;
	
	private static JedisPool jedisPool = null;
	
	private static ThreadLocal<Jedis> threadLocal = new ThreadLocal<Jedis>();
	
	/**
	 * 初始化Redis连接池
	 */
	static{
		try {
			JedisPoolConfig config = new JedisPoolConfig();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
