package Main;

import java.sql.*;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接
        String url="jdbc:mysql://localhost:3306/sys_system";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        //获取执行Sql语句的对象
        Statement statement = connection.createStatement();

        //执行Sql语句并执行
        String sql="select * from sys_user";
        String str="''";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int i=resultSet.getInt("uid");
            String name=resultSet.getString("username");
            System.out.println(i+"::"+name);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
