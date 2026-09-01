package com.example.springmvctest.controller;

import com.example.springmvctest.Dao.DeviceInfoDao;
import com.example.springmvctest.pojo.DeviceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    private DeviceInfoDao deviceInfoDao;

    @GetMapping("/devices")
    public String listDevices(Model model) {
        List<DeviceInfo> devices = deviceInfoDao.findAll();
        model.addAttribute("devices", devices);
        return "devices";
    }

    @GetMapping("/add")
    public String addDeviceForm() {
        return "add";
    }

    @PostMapping("/addDevice")
    public String addDevice(DeviceInfo device, Model model) {
        deviceInfoDao.save(device);
        model.addAttribute("device", device); // 把保存的设备信息传递给 JSP 页面
        return "save"; // 返回到 save.jsp 页面
    }

}
