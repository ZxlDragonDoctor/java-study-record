package com.zxl;

public class Mange extends Empolee{
    private double bone;

    public Mange(String name, double salary, double bone) {
        super(name, salary);
        this.bone = bone;
    }

    public double getBone() {
        return bone;
    }

    public void setBone(double bone) {
        this.bone = bone;
    }
    public void manage(){
        System.out.println(getName() + "正在实施管理");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bone;
    }
}
