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
                <li id="active"><a href="<%=basePath%>bill/selectList.com">账单管理</a></li>
                <li><a href="<%=basePath%>provider/selectList.com">供应商管理</a></li>
                <li><a href="<%=basePath%>user/selectList.com">用户管理</a></li>
                <li><a href="<%=basePath%>public/password.com">密码修改</a></li>
                <li><a href="<%=basePath%>user/loginOut.com">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>账单管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>订单编号：</strong><span>${bill.billCode }</span></p>
            <p><strong>商品名称：</strong><span>${bill.productName }</span></p>
            <p><strong>商品单位：</strong><span>${bill.productUnit }</span></p>
            <p><strong>商品数量：</strong><span>${bill.productCount }</span></p>
            <p><strong>总金额：</strong><span>${bill.totalPrice }</span></p>
            <p><strong>供应商：</strong><span>${bill.providerName }</span></p>
            <p><strong>是否付款：</strong>
            	<span>
            		<c:if test="${bill.isPayment == 1 }">待付款</c:if>
	                <c:if test="${bill.isPayment == 2 }">已付款</c:if>
            	</span>
            </p>

            <a href="<%=basePath%>bill/selectList.com">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="<%=basePath%>js/time.js"></script>

</body>
</html>