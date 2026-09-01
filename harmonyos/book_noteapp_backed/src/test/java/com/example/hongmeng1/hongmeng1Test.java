package com.example.hongmeng1;
import com.example.hongmeng1.dao.IBookNoteDAO;
import com.example.hongmeng1.Model.pojo.BookNote;
import com.example.hongmeng1.Model.pojo.User;
import com.example.hongmeng1.dao.IUserDAO;
import com.example.hongmeng1.service.UserService;
import com.example.hongmeng1.Model.dto.UserDTO;
import com.example.hongmeng1.Model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@SpringBootTest
public class hongmeng1Test {

    @Test
    void contextLoads() {
        User user = new User()
                .setId(1)
                .setUsername("kunkun1")
                .setPassword("123456")
                .setAvatar("avatar")
                .setNickname("管理员");
        log.debug("user: 信息为{}", user);
    }

    @Test
    void loggingLevelTest() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

    @Autowired
    private IUserDAO userDAO;

    @Test
    void selectUserByUsername() {
        User user = userDAO.getUserByUsername("kunkun1");
        log.info("user: {}", user);
    }


    @Autowired
    private UserService userService;

    @Test
    void selectUsers() {
        UserDTO login = userService.getLogin(new UserVO().setUsername("kunkun1").setPassword("123456"));
        log.info("login: {}", login);
    }
    @Autowired
    IBookNoteDAO iBookNoteDAO;
    @Test
    void selectNotes(){
        List<BookNote> bookNotes = iBookNoteDAO.selectList(null);
        System.out.println(bookNotes);
    }

}
