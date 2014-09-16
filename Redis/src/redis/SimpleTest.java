package redis;

import redis.clients.jedis.Jedis;

public class SimpleTest {

	public static void main(String[] args) {
		final RedisConnector connector = RedisConnector.getInstance();
		final Jedis jedis = connector.getJedis();

		//1. 등록
		final String key="study";
        jedis.set(key, "redis");
        
        //2. 검색
        String searchValue = jedis.get(key);
        System.out.println(searchValue);
        
        //3. 삭제
        jedis.del(key);
        String removeAfter = jedis.get(key);
        System.out.println(removeAfter);
	}
}
