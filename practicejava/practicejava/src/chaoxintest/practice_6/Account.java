package chaoxintest.practice_6;

public class Account {
//    1.定义一个Account账户类。类中有成员变量账户号  accountID，
//    账户余额balance，两个成员变量均为私有；定义公共的构造方法；
//    对成员变量accountID定义公共的get和set方法。在Test类中定义主方法，
//    实例化一个Account账户对象account，通过构造方法对account初始化，账户号为20190001，余额为1000。
//    使用set方法将账户号改为 20190002，并使用get方法获取并输出账户号。
    private String accountID;
    private double balance;

    public Account(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", balance=" + balance +
                '}';
    }
}
//class Test{
//    public static void main(String[] args) {
//        Account account = new Account("20190001", 1000);
//        System.out.println(account);
//        account.setAccountID("20190002");
//        System.out.println(account.getAccountID());
//    }
//}
