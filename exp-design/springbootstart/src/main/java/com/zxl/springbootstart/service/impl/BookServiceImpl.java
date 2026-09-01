package com.zxl.springbootstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxl.springbootstart.domain.Book;
import com.zxl.springbootstart.service.BookService;
import com.zxl.springbootstart.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
* @author 朱小龙
* @description 针对表【book】的数据库操作Service实现
* @createDate 2025-04-15 08:41:04
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService{

}




