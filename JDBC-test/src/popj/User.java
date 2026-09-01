package popj;


//实体类
public class User {
    private int uid;
    private String userName;
    private String userPwd;
    public User(){
    }

    public User(int uid, String userName, String userPwd) {
        this.uid = uid;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
