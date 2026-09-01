package com.zxl.houserent.view;

import com.zxl.houserent.modal.House;
import com.zxl.houserent.service.HouseService;

import java.util.Scanner;

//界面类
public class Menue {
    //主界面
    private boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    HouseService houseService = new HouseService();
    House[] houses = houseService.getHouses();

    public void mainMenue() {
        do {
            System.out.println("=========房屋出租系统==========");
            System.out.println("\t\t1" + "显示房屋出租列表");
            System.out.println("\t\t2" + "增加房屋");
            System.out.println("\t\t3" + "删除房屋");
            System.out.println("\t\t4" + "更改房屋");
            System.out.println("\t\t5" + "查找房屋");
            System.out.println("\t\t6" + "退出");

            System.out.println("请输入你的选择：");
            char choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    listHouse();
                    break;
                case '2':
                    createHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    findHouse();
                    break;
                case '6':
                    System.out.println("退出");
                    loop = false;
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入");
            }
        } while (loop);
        System.out.println("====你退出了房屋出租系统========");
    }
    //显示房屋列表界面
    //编号 房主 电话 月租 地址 状态（已出租/未出租）

    public void listHouse() {
        System.out.println("==========显示房屋出租列表=========");
        System.out.println("编号" + "\t\t" + "房主" + "\t\t" +
                "电话" + "\t\t\t\t" + "月租" + "\t\t" + "地址" + "\t\t" + "状态");
        for (int i = 0; i < houses.length; i++) {
            System.out.println(houses[i]);
        }
    }

    //增加房屋界面
    public void createHouse() {
        //编号 房主 电话 月租 地址 状态（已出租/未出租）
        System.out.println("==========增加房屋===============");
        System.out.println("请输入房主名：");
        String name = scanner.next();
        System.out.println("请输入电话：");
        String phone = scanner.next();
        System.out.println("请输入月租:");
        String rent = scanner.next();
        System.out.println("请输入地址：");
        String address = scanner.next();
        System.out.println("请输入状态：");
        String state = scanner.next();
        House house = new House(name, phone, rent, address, state);
        houses = houseService.create(house);
        System.out.println("添加房屋成功");
    }
    //删除房屋
    public void deleteHouse(){
        System.out.println("==========删除房屋=============");
        System.out.println("请输入你要删除的房屋的id：");
        int id = scanner.nextInt();
        if(houseService.delete(id)){
            houses = houseService.getHouses();
            System.out.println("删除房屋成功");
        }else {
            System.out.println("删除房屋失败");
        }

    }
    public void updateHouse(){
        System.out.println("请输入你要更改的房屋的id：");
        int id = scanner.nextInt();
        if(houseService.update(id)){
            houses = houseService.getHouses();
            System.out.println("修改成功");

        }else {
            System.out.println("该id不存在，修改失败");
        }
    }
    public void findHouse(){
        System.out.println("请输入你要查找的房屋的id：");
        int id = scanner.nextInt();
        int i = houseService.find(id);
        if(i!=-1){
            System.out.println("查找成功");
            System.out.println(houses[i]);
        }else{
            System.out.println("查找失败");
        }
    }
}

