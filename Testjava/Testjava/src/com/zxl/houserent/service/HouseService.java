package com.zxl.houserent.service;

import com.zxl.houserent.modal.House;

import java.util.Scanner;

public class HouseService {
   //显示房屋信息
    private House[] houses;
    Scanner scanner = new Scanner(System.in);

    public HouseService() {
        houses = new House[1];//创建对象，指定数组大小
        houses[0] = new House(0,"吴凯","17783366413",
                "2000","西夏区","未出租");

    }

    public House[] getHouses() {
        return houses;
    }
    public House[] create(House house){
        House[] houses1 = new House[houses.length+1];
        for (int i = 0; i < houses.length; i++) {
            houses1[i] = this.houses[i];
        }
        houses1[houses.length] = house;
        houses1[houses.length].addId();
        houses = houses1;
        return houses;
    }
    public boolean delete(int id){
        House[] houses2 = new House[houses.length-1];
        for(int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == id){
                for (int j = i; j <houses.length-1; j++) {
                    houses[j] = houses[j+1];
                }
                for (int k = 0; k < houses2.length; k++) {
                    houses2[k] = houses[k];
                }
                houses = houses2;
                return true;
            }

        }
        return  false;
    }
    public boolean update(int id){
        int index = find(id);
      if(index!=-1){
          System.out.println("请输入房主名：");
          houses[index].setName(scanner.next());
          System.out.println("请输入电话：");
          houses[index].setPhone(scanner.next());
          System.out.println("请输入月租:");
          houses[index].setRent(scanner.next());
          System.out.println("请输入地址：");
          houses[index].setAddress(scanner.next());
          System.out.println("请输入状态：");
          houses[index].setState(scanner.next());
          return true;
      }
      return false;

    }
    public int find(int id){
        for (int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == id){
                return i;
            }
        }
        return -1;
    }
}
