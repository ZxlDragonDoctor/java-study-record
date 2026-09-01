package com.example.hongmeng1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hongmeng1.Model.pojo.BookNote;
import com.example.hongmeng1.service.BookNoteService;
import com.example.hongmeng1.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class BookNoteController {
    @Autowired
    private BookNoteService bookNoteService;
    @GetMapping("get/notes")
    public Result<List<BookNote>> listBookNOte(){
        List<BookNote> bookNotes = bookNoteService.queryBookNotes();
        return Result.success(bookNotes);
    }
    @PostMapping("/save")
    public Result<Boolean>  saveNote(@RequestBody BookNote bookNote){
        int i = bookNoteService.insertBookNote(bookNote);
        System.out.println(i);
        return i>0?Result.success():Result.fail();
    }
    @DeleteMapping("/{noticeid}")
    public Result<Void> deleteBookNote(@PathVariable Integer noticeid){
        int i = bookNoteService.removeById(noticeid);
        return i>0?Result.success():Result.fail();
    }

}
