import redis.clients.jedis.Jedis;
 
public class RedisExample {
    public static void main(String[] args) {
        // 连接到Redis服务器，这里假设Redis运行在本地机器上，端口为6379
        Jedis jedis = new Jedis("localhost", 6379);
        
        // 检查服务器是否运行
        System.out.println("Server is running: " + jedis.ping());
        
        // 设置键值对
        jedis.set("key", "value");
        
        // 获取键对应的值
        String value = jedis.get("key");
        System.out.println("Get key value: " + value);
        
        // 关闭连接
        jedis.close();
    }
}