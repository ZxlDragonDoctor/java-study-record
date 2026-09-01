import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // 连接到MongoDB服务，默认连接到本地的27017端口
        MongoClient mongoClient = MongoClients.create();

        // 连接到数据库和集合（如果不存在将自动创建）
        MongoDatabase database = mongoClient.getDatabase("mydb"); // 使用你的数据库名称
        MongoCollection<Document> collection = database.getCollection("test"); // 使用你的集合名称

        // 创建一个文档并插入到集合中
        Document doc = new Document("name", "Alice").append("age", 24);
        collection.insertOne(doc);

        // 查询集合中的文档
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // 关闭MongoDB客户端
        mongoClient.close();
    }
}