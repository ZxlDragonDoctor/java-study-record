package com.zxl.userhomework_backed.controller;

import com.zxl.userhomework_backed.common.BaseResponse;
import com.zxl.userhomework_backed.common.ResultUtils;
import com.zxl.userhomework_backed.mapper.StudentMapper;
import com.zxl.userhomework_backed.model.pojo.Scores;
import com.zxl.userhomework_backed.model.vo.StuScores;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentMapper studentMapper;
    // 查询每科成绩
    @GetMapping("/find1")
    public BaseResponse<List<Scores>> findScoresBySubjectId(Integer subjectId){
        List<Scores> scores = studentMapper.findAllScoresBySubjectId(subjectId);
        return ResultUtils.success(scores);
    }

    @GetMapping("/find2")
    public BaseResponse<List<Scores>> findScores(Integer studentId){
        List<Scores> scores = studentMapper.findAllScoresByStudentId(studentId);
        return ResultUtils.success(scores);
    }
    @GetMapping("/find3")
    public BaseResponse<List<StuScores>> findAllStuScores(){
         List<StuScores> stuScores = studentMapper.findAllStuScores();
         return ResultUtils.success(stuScores);
    }
}
