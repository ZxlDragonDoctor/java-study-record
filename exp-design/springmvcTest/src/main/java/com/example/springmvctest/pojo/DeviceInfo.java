package com.example.springmvctest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    private Long id;
    private String typeNo;
    private BigDecimal price;
    private Date date;
}


