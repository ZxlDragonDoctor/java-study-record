package com.example.hongmeng1.Model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Note {
    private Integer noteId;
    private String title;
    private String content;
    private String author;
    private Date createTime;
    private Integer deleted;
    private String images;
}
