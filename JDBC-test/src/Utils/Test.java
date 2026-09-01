package Utils;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import popj.User;

import java.util.List;

public class Test {
    private static UserDao userDao;
    public static void main(String[] args) {
        userDao = new UserDaoImpl();
//        List<User> users = userDao.selectAll();
//        System.out.println(users);
       // userDao.insert(new User(7,"xieqiying","e10adc3949ba59abbe56e057f20f883j"));
//        User user = userDao.selectByUid(7);
//        user.setUserName("zen");
//        userDao.update(user);
//        user = userDao.selectByUid(7);
    //    userDao.delete(7);
        List<User> users = userDao.selectAll();
        System.out.println(users);
    }
}
