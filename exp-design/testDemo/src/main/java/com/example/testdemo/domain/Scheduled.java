package com.example.testdemo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName scheduled
 */
@TableName(value ="scheduled")
@Data
public class Scheduled implements Serializable {
    /**
     * 
     */
    @TableId
    private String cronId;

    /**
     * 
     */
    private String cronName;

    /**
     * 
     */
    private String cron;

    @TableField(exist = false)
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
        Scheduled other = (Scheduled) that;
        return (this.getCronId() == null ? other.getCronId() == null : this.getCronId().equals(other.getCronId()))
            && (this.getCronName() == null ? other.getCronName() == null : this.getCronName().equals(other.getCronName()))
            && (this.getCron() == null ? other.getCron() == null : this.getCron().equals(other.getCron()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCronId() == null) ? 0 : getCronId().hashCode());
        result = prime * result + ((getCronName() == null) ? 0 : getCronName().hashCode());
        result = prime * result + ((getCron() == null) ? 0 : getCron().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cronId=").append(cronId);
        sb.append(", cronName=").append(cronName);
        sb.append(", cron=").append(cron);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}