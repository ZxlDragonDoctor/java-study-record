package com.example.springmvctest.Dao;


import com.example.springmvctest.pojo.DeviceInfo;
import com.example.springmvctest.tools.DbConnectPool;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

@Repository
public class DeviceInfoDao {

    public List<DeviceInfo> findAll() {
        String sql = "select * from device_info";
        List<DeviceInfo> list = new ArrayList<>();
        try(Connection conn = DbConnectPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                // 通过字段检索
                Long id = resultSet.getLong("id");
                String typeNo = resultSet.getString("typeNo");
                BigDecimal price = resultSet.getBigDecimal("price");
                Date date = resultSet.getDate("date");
                DeviceInfo deviceInfo = new DeviceInfo(id, typeNo, price, date);
                list.add(deviceInfo);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean save(DeviceInfo device) {
        boolean n = false;
        String sql = "insert into device_info(id,typeNo, price, date) value (?,?,?,?)";
        try(Connection conn = DbConnectPool.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1,device.getId());
            pstmt.setString(2,device.getTypeNo());
            pstmt.setBigDecimal(3,device.getPrice());
            pstmt.setDate(4, device.getDate());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                n = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return n;
    }
}
