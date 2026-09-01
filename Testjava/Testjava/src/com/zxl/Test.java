package com.zxl;

public class Test {
    public void  showEmployee(Empolee e){
        System.out.println(e.getName()
                + "的工资为" + e.getAnnual());
    }
    public void testWork(Empolee e){
        if(e instanceof Worker){
            ((Worker) e).work();
        }else if(e instanceof Mange){
            ((Mange) e).manage();
        }

    }
}
