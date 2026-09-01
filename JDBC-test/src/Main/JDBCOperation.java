package Main;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCOperation {
    @Test
    public void testQuery() throws SQLException {

        String url="jdbc:mysql://localhost:3306/sys_system";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "select * from sys_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int uid=resultSet.getInt("uid");
            String name=resultSet.getString("username");
            String pwd=resultSet.getString("user_pwd");
            System.out.println(uid+":"+name+":"+pwd);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
    @Test
    public void TestInsert() throws SQLException {
        String url="jdbc:mysql://localhost:3306/sys_system";
        String username="root";
        String password="zxl123";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql="insert into sys_user(uid,username) value(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,5);
        preparedStatement.setString(2,"liushuhao");

        int res = preparedStatement.executeUpdate();
        if(res>0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        preparedStatement.close();
        connection.close();
    }


}
