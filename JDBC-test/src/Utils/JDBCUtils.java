package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static {
        try{
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(resourceAsStream);
        dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                Connection connection1 = dataSource.getConnection();
                threadLocal.set(connection1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  threadLocal.get();
    }
    public static void release()  {
        Connection connection = threadLocal.get();
        try {
            if (connection != null) {
                threadLocal.remove();
                //在连接放回连接池之前修改它的事务提交为自动提交
                connection.setAutoCommit(true);
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
