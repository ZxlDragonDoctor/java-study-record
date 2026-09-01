package com.zxl.chaoxintest;

import java.util.Scanner;

/**
 * 该代码有待修改，没有增加每个值的范围判定
 */
public class Economic {
    //年利率
    private  double d;
    //本金
    private  double x;
    //存款年限
    private  double n;
    //存款总额预期值
    private  double z;
    //求z存款总额预期值
    public double calz(double d,double x,double n){
        this.setD(d);
        this.setN(n);
        this.setX(x);
       return  x *Math.pow((1+d),n);
    }
    //求本金x
    public double calx(double d,double n,double z){
        this.setN(n);
        this.setD(d);
        this.setZ(z);
        return z/Math.pow((1+d),n);
    }
    //求存款年限
    public double caln(double d,double z,double x){
        this.setZ(z);
        this.setD(d);
        this.setX(x);
        return (Math.log(1)/Math.log(z)-Math.log(1)/Math.log(x))/Math.log(1)/Math.log(1+d);
    }
    //求年利率
    public double cald(double z,double n,double x){
        this.setX(x);
        this.setN(n);
        this.setN(n);
        return Math.pow((z/x),(1/n)) + 1;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
