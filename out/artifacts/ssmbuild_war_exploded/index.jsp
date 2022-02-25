<%--
  Created by IntelliJ IDEA.
  User: 58280
  Date: 2022/2/11
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>

    <style>

        a{
          text-decoration: none;
          color: black;
          font-size: 18px;
        }

        h3{
          width: 180px;
          height:38px;
          margin: 100px auto;
          text-align: center;
          line-height: 38px;
          background: deepskyblue;
          border-radius: 5px;
        }
    </style>

  </head>
  <body>

    <h3>书籍管理系统首页</h3>

<%--    <H3>--%>
<%--      <a href="${pageContext.request.contextPath}/book/allBook">进入书籍页面</a>--%>
<%--    </H3>--%>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <div>
            用户名：<input type="text" name="username">
        </div>
        <div>
            密码：<input type="text" name="password">
        </div>
        <div>
            <input type="submit" class="btn btn-primary" value="提交">
        </div>
    </form>

  </body>
</html>
