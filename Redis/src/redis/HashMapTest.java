package redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class HashMapTest {
	 /**
     * hashmap 테스트
     * */
	private final Jedis jedis = new Jedis("127.0.0.1", 6379);

	public boolean userExist(final String uid) {
		return (boolean) jedis.exists(uid);
	}

	public void initInsertUser(final String id, final String name, final int age) {
		final Map<String, String> userProperties = new HashMap<String, String>();
		userProperties.put("name", name);
		userProperties.put("age", String.valueOf(age));

		jedis.hmset(id, userProperties);
	}

	public Information getUser(final String id) {
		final Information result = new Information();
		final Map<String, String> userProperties = jedis.hgetAll(id);

		result.setId(id);
		result.setName(userProperties.get("name"));
		result.setAge(Integer.parseInt(userProperties.get("age")));

		return result;
	}

	public void incrementAge(String id) {
		updateHashMap(id, "age");
	}

	private void updateHashMap(final String id, final String name) {
		jedis.hincrBy(id, name, 1);

	}

	class Information {
		private String id;
		private String name;
		private int age;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Information [id=" + id + ", name=" + name + ", age=" + age + "]";
		}
	}
	
	public static void main(String args[]){
		HashMapTest test = new HashMapTest();
		test.initInsertUser("1", "jung", 29);
		Information result = test.getUser("1");
		System.out.println(result);
	}
}
