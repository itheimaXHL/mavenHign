<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2018/9/15
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/getParameter.js"></script>
    <script>
        $(function () {
            $.post("items/findAllAjax",{},function (data) {
                alert(data);
            },"json");
        })
    </script>
</head>
<body>
    <table border="1px" cellspacing="0" cellpadding="0">
        <%--<c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.createtime}</td>
                <td>${item.detail}</td>
                <td><a href="/items/delete?id=${item.id}">删除</a></td>
                <td><a href="/items/findById?id=${item.id}">修改</a></td>
            </tr>
        </c:forEach>--%>
    </table>
    <a href="/insert.html">添加</a>
</body>
</html>
