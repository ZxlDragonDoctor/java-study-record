package com.zxl.userhomework_backed.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StuScores {
    //    s.id,
//    s.name AS student_name,
//    sub.subject_id,
//    sub.name AS subject_name,
//    sc.score
    private Integer id;
    private String studentName;
    private Integer subjectId;
    private String subjectName;
    private BigDecimal score;

}
