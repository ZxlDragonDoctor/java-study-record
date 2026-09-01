package controller;

import org.junit.jupiter.api.Test;
import popj.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_01 {
    @Test
    public void testQuery() throws SQLException {

        String url="jdbc:mysql://localhost:3306/sys_system";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from sys_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        User us = null;
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            int uid=resultSet.getInt("uid");
            String name=resultSet.getString("username");
            String pwd=resultSet.getString("user_pwd");
            us=new User(uid,name,pwd);
            users.add(us);
            System.out.println(us);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    //主键回显
    @Test
    public void testInsert() throws SQLException {
        String url="jdbc:mysql://localhost:3306/sys_system";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql="insert into sys_user(username,user_pwd) value(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,"jinke");
        preparedStatement.setString(2,"e10adc3949ba59abbe56e057f20f883b");

        int res = preparedStatement.executeUpdate();
        ResultSet resultSet = null;
        if(res>0){
            System.out.println("成功");
             resultSet = preparedStatement.getGeneratedKeys();
             if(resultSet.next()){
                 System.out.println(resultSet.getInt(1));
             }
        }else {
            System.out.println("失败");
        }
        if(resultSet!=null){
            resultSet.close();
        }
        preparedStatement.close();
        connection.close();
    }
    //批量操作
    @Test
    public void testBatch() throws SQLException {
        String url="jdbc:mysql://localhost:3306/JdbcTest?rewriteBatchedStatements=true";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql="insert into person_name(last_name, title_name, total_name) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        String title_name="Robot";
        for(int i=0;i<10000;i++){
            preparedStatement.setString(1,""+i);
            preparedStatement.setString(2,title_name);
            preparedStatement.setString(3,title_name+i);
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }

}
