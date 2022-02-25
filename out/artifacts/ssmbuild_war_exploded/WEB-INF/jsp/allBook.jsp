<%@ page import="com.kj.pojo.Books" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 58280
  Date: 2022/2/11
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>

    <%-- BootStrap 美化界面--%>
    <link href= "https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<%--具体含义参考对应BootStrap模板的教程--%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —————— 显示所有书籍</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <%--toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
                    <%--toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
            </div>
            <div class="col-md-8 column">
                <%-- 查询书籍 --%>
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                    <span style="color: red;font-weight: bold">${error}</span>
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称！">
                    <input type="submit" class="btn btn-primary" value="查询">
                </form>
            </div>
        </div>

    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <%-- 书籍从数据库中查询出来,即从list中遍历出来 --%>
                <tbody>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a>
                                 &nbsp; | &nbsp;
                                    <%--  RestFul风格 --%>
                                <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-8 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/loginOut">退出登录</a>
        </div>
    </div>
</div>

</body>
</html>