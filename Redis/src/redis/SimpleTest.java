package redis;

import redis.clients.jedis.Jedis;

public class SimpleTest {

	public static void main(String[] args) {
		final RedisConnector connector = RedisConnector.getInstance();
		final Jedis jedis = connector.getJedis();

        jedis.set("study", "redis");
        String value = jedis.get("study");
        System.out.println(value);
	}

}
