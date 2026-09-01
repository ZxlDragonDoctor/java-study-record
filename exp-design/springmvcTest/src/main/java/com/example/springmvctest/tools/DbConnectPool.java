package com.example.springmvctest.tools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库连接池配置工具类
 */
public class DbConnectPool {
    private static DataSource  getDataSource(){
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup(
                    "java:comp/env/jdbc/deviceDS");
        }catch(NamingException ne){
            System.out.println("异常:"+ne);
        }
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try{
            conn =  dataSource.getConnection();
        }catch(SQLException sqle){
            System.out.println("异常:"+sqle);
        }
        return  conn;
    }
}
