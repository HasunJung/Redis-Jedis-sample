package redis;

import redis.clients.jedis.Jedis;

public class RedisConnector {
	private static RedisConnector instance = null;
	private final Jedis jedis;
	
	private RedisConnector(){
		jedis = new Jedis("127.0.0.1", 6379);
	}
	
	public static RedisConnector getInstance(){
		if(instance == null) {
			synchronized(RedisConnector.class) {
				if(instance == null) {
					instance = new RedisConnector();
				}
			}
		}
		return instance;
	}
	
	public Jedis getJedis(){
		return jedis;
	}
}
