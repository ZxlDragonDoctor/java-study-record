package test.templatePattern;

// 抽象类：定义模板方法
abstract class AbstractAccount {
    protected double interest;

    // 模板方法：定义计算流程
    public final void calculateInterest() {
        queryAccount();
        determineType();
        computeInterest(); // 由子类实现
        displayInterest();
    }

    // 公共步骤
    protected void queryAccount() {
        System.out.println("Querying user account from database...");
    }

    protected void determineType() {
        System.out.println("Determining account type: " + this.getClass().getSimpleName());
    }

    protected void displayInterest() {
        System.out.println("Calculated Interest: " + interest);
    }

    // 抽象步骤：由子类实现
    protected  abstract  void  computeInterest();
}

// 定期账户：利息高
class SavingAccount extends AbstractAccount {
    @Override
    protected void computeInterest() {
        System.out.println("Computing interest for SavingAccount...");
        interest = 10000 * 0.035; // 假设利率3.5%
    }
}

// 活期账户：利息低
class CurrentAccount extends AbstractAccount {
    @Override
    protected void computeInterest() {
        System.out.println("Computing interest for CurrentAccount...");
        interest = 10000 * 0.005; // 假设利率0.5%
    }
}

class BankSystemTest {
    public static void main(String[] args) {
        System.out.println("==== Saving Account ====");
        AbstractAccount saving = new SavingAccount();
        saving.calculateInterest();

        System.out.println("\n==== Current Account ====");
        AbstractAccount current = new CurrentAccount();
        current.calculateInterest();
    }
}

