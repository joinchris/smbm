<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'billAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>css/public.css"/>
    <link rel="stylesheet" href="<%=basePath%>css/style.css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
            <a href="<%=basePath%>user/loginOut.com">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a>温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                    <li><a href="<%=basePath%>bill/selectList.com">账单管理</a></li>
		            <li><a href="<%=basePath%>provider/selectList.com">供应商管理</a></li>
		            <li id="active"><a href="<%=basePath%>user/selectList.com">用户管理</a></li>
		            <li><a href="<%=basePath%>public/password.com">密码修改</a></li>
		            <li><a href="<%=basePath%>user/loginOut.com">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
	                <span>用户名：</span>
	                <input type="text" id="userName" name="userName" value="" placeholder="请输入用户名"/>
	                <input type="button" value="查询" onclick="selectUser();" />
               	 	<a href="<%=basePath%>user/userAddJsp.com">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                    <c:forEach items="${userList }" var="user">
                <tr>
                    	<td>${user.userCode}</td>
	                    <td>${user.userName }</td>
	                    <td>
	                    	<c:if test="${user.gender == 1 }">男</c:if>
	                    	<c:if test="${user.gender == 2 }">女</c:if>
	                    </td>
	                    <td>${user.age }</td>
	                    <td>${user.phone }</td>
	                    <td>${user.userRoleName }</td>
	                    <td>
	                        <a href="<%=basePath%>user/viewJsp.com?id=${user.id}"><img src="<%=basePath%>img/read.png" alt="查看" title="查看"/></a>
	                        <a href="<%=basePath%>user/updateJsp.com?id=${user.id}"><img src="<%=basePath%>img/xiugai.png" alt="修改" title="修改"/></a>
	                      	<a class="deleteUser" uid=${user.id }><img src="<%=basePath%>img/schu.png" alt="删除" title="删除"/></a>
	                    </td>
	                	</tr>
                    </c:forEach>
            </table>

        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/user.js"></script>
<script src="<%=basePath%>js/time.js"></script>


</body>
</html>
