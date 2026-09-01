package Dao.Impl;

import Dao.BaseDao;
import Dao.UserDao;
import org.junit.jupiter.api.Test;
import popj.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao  {
    @Override
    public List<User> selectAll() {
        String sql = "select uid,username as userName,user_pwd as userPwd from sys_user ";
        List<User> users = null;
        try {
            users = executeQuery(User.class, sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;

    }

    @Override
    public User selectByUid(int uid) {
        String sql="select uid,username as userName,user_pwd as userPwd from sys_user where uid=?";
        try {
            return singleQuery(User.class,sql,uid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User user) {
        String sql = "update sys_user set user_pwd=?,username=? where uid=?";
        return executeUpdate(sql,user.getUserPwd(),user.getUserName(),user.getUid());

    }

    @Override
    public int insert(User user) {
       String sql = "insert into sys_user values(?,?,?)";
      return executeUpdate(sql,user.getUid(),user.getUserName(),user.getUserPwd());
    }

    @Override
    public  int delete(Integer uid) {
        String sql = "delete from sys_user where uid = ?";
        return  executeUpdate(sql,uid);
    }
}
