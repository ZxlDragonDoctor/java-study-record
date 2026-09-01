package Dao;

import Utils.JDBCUtils;
import sun.awt.image.PixelConverter;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BaseDao {
    //同用的增删改的方法
    public int executeUpdate(String sql, Object... params)  {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                if(connection.getAutoCommit()){
                    JDBCUtils.release();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return row;
    }
    //通用的查询的方法
    public <T> List<T> executeQuery(Class<T> clazz, String sql, Object... params) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        //包含了列的数量和列的名称
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<T> list = new LinkedList<>();
        while (resultSet.next()) {
            T t = clazz.newInstance();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                Object value = resultSet.getObject(i);
                String filedName = metaData.getColumnLabel(i);
                Field field = clazz.getDeclaredField(filedName);
                field.setAccessible(true);
                field.set(t, value);
            }
            list.add(t);
        }
        resultSet.close();
        preparedStatement.close();
        if(connection.getAutoCommit()){//！！！！！只有当事物为自动提交的时才释放连接，手动提交方式要自己去释放连接
            JDBCUtils.release();
        }
        return list;
    }
    //返回查询的单个对象
    public <T> T singleQuery(Class<T> clazz, String sql, Object... params) throws Exception {
        List<T> list = executeQuery(clazz, sql, params);
        if(list!=null&& !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
