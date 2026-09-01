package com.zxl.houserent.modal;

public class House {
    //编号 房主 电话 月租 地址 状态（已出租/未出租）
    private int  id;
    private String name;
    private String  phone;
    private String rent;
    private  String address;
    private  String state;

    public House(int id, String name, String phone, String rent, String address, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.rent = rent;
        this.address = address;
        this.state = state;
    }

    public House(String name, String phone, String rent, String address, String state) {
        this.name = name;
        this.phone = phone;
        this.rent = rent;
        this.address = address;
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t\t" + phone +
                "\t\t" + rent +
                "\t" + address +
                "\t" + state
                ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void addId(){
        this.id++;

    }
}


