package com.zxl.chaoxintest;

public class RewardTest {
    //    企业发放的奖金根据利润提成。
//    利润(I)低于或等于10万元时，奖金可提10%；
//    利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
//            20万到40万之间时，高于20万元的部分，可提成5%；
//            40万到60万之间时高于40万元的部分，可提成3%；
//            60万到100万之间时，高于60万元的部分，可提成1.5%，
//    高于100万元时，超过100万元的部分按1%提成，
//    从键盘输入当月利润I，求应发放奖金总数？
    public double menue(double profit) {
        if (profit <= 10) {
            return this.reward_1(profit);
        } else if (profit <= 20) {
            return this.reward_2(profit);
        } else if (profit <= 40) {
            return this.reward_3(profit);
        } else if (profit <= 60) {
            return this.reward_4(profit);
        } else if (profit <= 100) {
            return this.reward_5(profit);
        } else if (profit > 100) {
            return this.reward_6(profit);
        }
        return 0;
    }

    //    利润(I)低于或等于10万元时，奖金可提10%；
    public double reward_1(double profit) {
        return profit * (10.0 / 100);

    }

    //    利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可提成7.5%；
    public double reward_2(double profit) {
        return this.reward_1(10.0) + (profit - 10) * (7.5 / 100);
    }

    //    20万到40万之间时，高于20万元的部分，可提成5%；
    public double reward_3(double profit) {
        return this.reward_2(20) + (profit - 20) * (5.0 / 100);

    }

    //      40万到60万之间时高于40万元的部分，可提成3%；
    public double reward_4(double profit) {
        return this.reward_3(40) + (profit - 40) * (3.0 / 100);

    }

    //      60万到100万之间时，高于60万元的部分，可提成1.5%，
    public double reward_5(double profit) {
        return this.reward_4(60) + (profit - 60) * (1.5 / 100);
    }

    //    高于100万元时，超过100万元的部分按1%提成，
    public double reward_6(double profit) {
        return this.reward_5(100) + (profit - 100) * (1.0 / 100);
    }

}
