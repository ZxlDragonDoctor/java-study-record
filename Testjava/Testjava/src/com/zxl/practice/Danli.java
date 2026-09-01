package com.zxl.practice;


import java.util.Stack;

public class Danli {
    public static void main(String[] args) {
        Dog A = Dog.getA();
        System.out.println(A);
        Cat_ B = Cat_.getCat();
        System.out.println(B);
    }
}
//单例饿汉式
class Dog{
    private  String name;
    private static Dog a = new Dog("花花");

    private  Dog(String name) {
        this.name = name;
    }

    public static Dog getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}
//单例懒汉式
class Cat_{
    private String name;
    private static Cat_ cat;
    public static Cat_ getCat(){
        if(cat == null){
            cat = new Cat_("黑黑");
        }
        return cat;
    }

    public Cat_(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat_{" +
                "name='" + name + '\'' +
                '}';
    }
}
