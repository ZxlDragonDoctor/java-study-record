package com.example.hongmeng1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hongmeng1.Model.pojo.BookNote;
import com.example.hongmeng1.dao.IBookNoteDAO;
import com.example.hongmeng1.exception.ServiceExceptionHandler;
import com.example.hongmeng1.service.BookNoteService;
import com.example.hongmeng1.utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookNoteServiceImpl implements BookNoteService {

    @Autowired
    private IBookNoteDAO iBookNoteDAO;
    @Override
    public List<BookNote> queryBookNotes() {
        return iBookNoteDAO.selectList(null);
    }

    @Override
    @Transactional
    public int insertBookNote(BookNote bookNote) {
        QueryWrapper<BookNote> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",bookNote.getTitle());
        BookNote bookNote1 = iBookNoteDAO.selectOne(queryWrapper);
        System.out.println(bookNote1);
        if(bookNote1!=null){
            throw new ServiceExceptionHandler(ResponseCode.ERROR,"该标题已存在");
        }
        return iBookNoteDAO.insert(bookNote);
    }

    @Override
    @Transactional //开启事物
    public int removeById(Integer noticeid) {

        return iBookNoteDAO.deleteById(noticeid);
    }
}
