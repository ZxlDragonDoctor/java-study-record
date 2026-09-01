package com.example.hongmeng1.service;

import com.example.hongmeng1.Model.pojo.BookNote;

import java.util.List;

public interface BookNoteService {
    List<BookNote> queryBookNotes();
    int insertBookNote(BookNote bookNote);

    int removeById(Integer noticeid);
}
