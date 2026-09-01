package com.zxl.product.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class Product {
    private Long id;
    private String productName;
    private BigDecimal price;
    private int num;
}
