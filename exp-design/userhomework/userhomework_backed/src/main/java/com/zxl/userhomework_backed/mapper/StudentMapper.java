package com.zxl.userhomework_backed.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxl.userhomework_backed.model.pojo.Scores;
import com.zxl.userhomework_backed.model.pojo.Students;
import com.zxl.userhomework_backed.model.pojo.Subjects;
import com.zxl.userhomework_backed.model.pojo.Users;
import com.zxl.userhomework_backed.model.vo.StuScores;

import java.util.List;

/**
 * @author 朱小龙
 * @description  对student,subject,score表进行操作
 * @createDate 2025-04-15 17:43:21
 * @Entity generator.domain.Users
 */
public interface StudentMapper extends BaseMapper<Users> {
        //查看每个学生所有成绩
        List<Scores>  findAllScoresByStudentId(Integer StudentId);
        //查看每个科目所有成绩
        List<Scores>  findAllScoresBySubjectId(Integer subjectId);
        //每个学生的所有成绩（包括每门科目及对应分数）
        List<StuScores> findAllStuScores();
}

