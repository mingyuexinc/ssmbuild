<%--
  Created by IntelliJ IDEA.
  User: 58280
  Date: 2022/2/12
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href= "https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>

    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%-- 注意：这里无法显式地拿到修改书籍的ID--%>
        <%-- 解决方案：前端传递隐藏域:前端不可见，但是可以隐藏地传到后台--%>

        <input type="hidden" name="bookID" value="${QBook.bookID}">

        <div class="form-group">
            <label>书籍名称</label>
            <%-- 注意此处bookName的只必须和实体类中对应一致,否则为null --%>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" required>
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>

</div>

</body>
</html>
