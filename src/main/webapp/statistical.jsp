<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Score Statisical</title>

    <script src="static/jquery-3.2.1.min.js" type="text/javascript"></script>
    <!-- 自定义jquery -->
<%--    <script type="text/javascript">--%>
<%--        $(function(){--%>
<%--            $("button").click(function(){--%>
<%--                if($("input").val()==null||$("input").val()==" "){--%>
<%--                    alert("查询的答案不能为空");--%>
<%--                    return false;--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    </script>--%>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="static/bootstrap.min.css">
    <style type="text/css">
        #div0 {
            background-color: pink;
            width: 250px;
            height: 740px;
        }

        li {
            margin-top: 50px;
            padding-top: 50px;
        }

        #div1 {
            color:red;
            margin-left:500px;
            margin-top:-460px;
            font-size: 20px;
        }
        input{
            width:400px;
        }
    </style>
</head>
<body>
<div id="div0" class="bs-example" data-example-id="simple-nav-stacked">
    <tr>教师工号:${pageContext.request.session.getAttribute("teacher").teacherId}</tr>
    <br>
    <tr><a href="login.jsp">返回登录界面</a></tr>
    <ul class="nav nav-pills nav-stacked nav-pills-stacked-example">
        <li><a href="teacherIndex.jsp">导入试题</a></li>
        <li><a href="controlSubject">管理试题</a></li>
        <li><a href="findSubject.jsp" class="active">查询试题</a></li>
        <li><a href="findStudent">管理学生</a></li>
        <li class="active"><a href="#">分数统计</a></li>
    </ul>
</div>
<div id="div1">
    <tr>考试人数:</tr>${score.countStudent}
    <br>
    <tr>最高分:</tr>${score.maxScore}
    <br>
    <tr>最低分:</tr>${score.minScore}
    <br>
    <tr>平均分:</tr>${score.averageScore}
<%--    <form method="post" action="findSubject">请输入你要搜索的题目:<input type="text" name="subjectTitle"></input> <button class="btn btn-success" type="submit">查询</button></form>--%>
</div>
</body>
</html>