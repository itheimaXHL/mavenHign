<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/9/15
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/items/update" method="post">
        <input type="hidden" name="id" >
        姓名:<input type="text" name="name" value="${item.name}"><br>
        价格:<input type="text" name="price" value="${item.price}"><br>
        时间:<input type="text" name="createtime" value="${item.createtime}"><br>
        详细:<input type="text" name="detail" value="${item.detail}"><br>
        <input type="submit" value="修改">
    </form>
</body>
</html>
