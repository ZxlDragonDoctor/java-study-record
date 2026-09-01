package controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import jdk.nashorn.internal.ir.SplitReturn;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {
    //硬链接
    @Test
    public void testHardConnection() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///JdbcTest");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("zxl123");

        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(20);

        Connection connection = druidDataSource.getConnection();

        //crud

        //将连接放回链接池
        connection.close();
    }
    //软连接
    @Test
    @SuppressWarnings({"all"})
    public void testSoftConnection() throws Exception {
//        问题一：
//
//        person.csv文件中每行包含一个人的first name和last name，中间用逗号隔开。如下：
//
//        Jill,Doe Joe,Doe Justin,Doe Jane,Doe John,Doe
//
//        要求读取文件中的人名，转化为大写，再存到数据库中。
        Properties properties = new Properties();

        InputStream resourceAsStream = DruidTest.class.getClassLoader()
                .getResourceAsStream("db.properties");
        properties.load(resourceAsStream);
        //获取Druid连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接对象
        Connection connection = dataSource.getConnection();
        //crud
        //读取文件
        File file = new File("D:\\idea_java project\\Test-csv\\resources\\person.csv");
        BufferedReader buf = null;
        //获取执行sql对象
        String sql = "insert into person_name(title_name,last_name,total_name) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        try{
            buf = new BufferedReader(new FileReader(file));
            String str = "";
            while ((str= buf.readLine())!=null){
                //字符处理
                str  = str.toUpperCase();
                String[] arr = str.split(",");
                //写入数据库
                preparedStatement.setString(1,arr[0]);
                preparedStatement.setString(2,arr[1]);
                preparedStatement.setString(3,arr[0]+arr[1]);
                int count = preparedStatement.executeUpdate();
                if(count>0){
                    System.out.println("插入数据库成功");
                }else {
                    System.out.println("插入数据库失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭Io流
            if(buf!=null){
                buf.close();
            }
        }
        //回收连接
        preparedStatement.close();
        connection.close();
    }
}
