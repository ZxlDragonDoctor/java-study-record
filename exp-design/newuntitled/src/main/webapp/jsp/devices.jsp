<!DOCTYPE html>
<html>
<head>
    <title>设备列表</title>
</head>
<body>
<h1>设备列表</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>类型编号</th>
        <th>价格</th>
        <th>出厂日期</th>
    </tr>
    <c:forEach var="device" items="${devices}">
        <tr>
            <td>${device.id}</td>
            <td>${device.typeNo}</td>
            <td>${device.price}</td>
            <td>${device.date}</td>
        </tr>
    </c:forEach>
</table>
<a href="/add">添加设备</a>
</body>
</html>
