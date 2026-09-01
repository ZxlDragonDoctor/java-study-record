package com.zxl.springbootstart.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName book
 */
@Data
public class Book implements Serializable {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String auther;

    /**
     * 
     */
    private BigDecimal price;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAuther() == null ? other.getAuther() == null : this.getAuther().equals(other.getAuther()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAuther() == null) ? 0 : getAuther().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", auther=").append(auther);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}