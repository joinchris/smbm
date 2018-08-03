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
            <span>账单管理页面 >> 订单修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">订单编码：</label>
                    <input type="text" name="billCode" id="billCode" value="${bill.billCode}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="${bill.productName}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="${bill.productUnit}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <input type="text" name="productCount" id="productCount" value="${bill.productCount}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="totalPrice">总金额：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value="${bill.totalPrice}"/>
                    <span>*</span>
                </div>
                <div>
                	 <label >供应商：</label>
                    <select id="providerId" >
                    	<option >--请选择相应的提供商--</option>
                    	<c:forEach items="${providerList }" var="provider" >
                    		<option <c:if test="${bill.providerId == provider.id}">selected="selected"</c:if> value="${provider.id }" >${provider.proName }</option>
                    	</c:forEach>
                    </select>
                </div>
                <div>
                    <label >是否付款：</label>
                    <select id="isPayment">
                    	<option value="1" <c:if test="${bill.isPayment == 1}">selected="selected"</c:if> >待付款</option>
                    	<option value="2" <c:if test="${bill.isPayment == 2}">selected="selected"</c:if>>已付款</option>
                    </select>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="billList.html">返回</a>-->
                    <input type="hidden" id="id" value="${bill.id }" >
                    <input type="button" value="保存" onclick="modifyBill();"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/bill.js"></script>
<script src="<%=basePath%>js/time.js"></script>

</body>
</html>