<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>添加设备</title>
</head>
<body>
<h2>添加设备</h2>
<form action="/add" method="post">
    <label for="id">设备ID：</label>
    <input type="text" id="id" name="id"><br><br>

    <label for="typeNo">设备型号：</label>
    <input type="text" id="typeNo" name="typeNo"><br><br>

    <label for="price">设备价格：</label>
    <input type="text" id="price" name="price"><br><br>

    <label for="date">设备日期：</label>
    <input type="text" id="date" name="date"><br><br>

    <button type="submit">提交</button>
</form>
</body>
</html>
