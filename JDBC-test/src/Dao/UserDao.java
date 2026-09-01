package Dao;

import popj.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();
    User selectByUid(int uid);
    int update(User user);
    int insert(User user);
    int delete(Integer uid);
}
