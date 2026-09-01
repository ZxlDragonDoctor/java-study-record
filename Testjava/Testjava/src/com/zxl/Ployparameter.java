package com.zxl;

public class Ployparameter {
    public static void main(String[] args){
        Worker worker = new Worker("wukai",2000);
        Mange mange = new Mange("wanzeng",4000,5000);
        Test test = new Test();
        test.showEmployee(worker);
        test.showEmployee(mange);
        test.testWork(worker);
        test.testWork(mange);
        System.out.println("hello".equals("abc"));


    }

}
