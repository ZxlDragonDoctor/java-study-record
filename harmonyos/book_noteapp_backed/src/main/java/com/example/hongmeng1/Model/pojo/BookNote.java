package com.example.hongmeng1.Model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data //getter和setteer
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("note")
public class BookNote {
    @TableId(type = IdType.AUTO)
    private Integer noteid;
    private String title;
    private String author;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String ctime;
    @TableLogic
    private Integer deleted;
    private String images;
}
