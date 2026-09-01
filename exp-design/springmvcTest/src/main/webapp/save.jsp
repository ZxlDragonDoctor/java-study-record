<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>保存成功</title>
</head>
<body>
<h2>保存成功！</h2>
<p>新增加的设备信息：</p>
<ul>
    <li>设备ID：${device.id}</li>
    <li>设备型号：${device.typeNo}</li>
    <li>设备价格：${device.price}</li>
    <li>设备日期：${device.date}</li>
</ul>
<a href="/devices">返回设备列表</a>
</body>
</html>
