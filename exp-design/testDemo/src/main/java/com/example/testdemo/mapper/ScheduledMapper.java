package com.example.testdemo.mapper;

import com.example.testdemo.domain.Scheduled;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
* @author 朱小龙
* @description 针对表【scheduled】的数据库操作Mapper
* @createDate 2025-04-22 10:46:19
* @Entity generator.domain.Scheduled
*/
@Repository
@Mapper
public interface ScheduledMapper extends BaseMapper<Scheduled> {
    @Select("select cron from scheduled where cron_id = #{id}")
    public String getCron(int id);
}




