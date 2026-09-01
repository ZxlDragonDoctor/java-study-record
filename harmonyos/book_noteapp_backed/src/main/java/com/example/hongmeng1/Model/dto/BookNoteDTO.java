package com.example.hongmeng1.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BookNoteDTO {
    private Integer noteid;
    private String title;
    private String author;
    private Date ctime;
    private String images;
}
