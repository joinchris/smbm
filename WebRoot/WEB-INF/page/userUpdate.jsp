<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userUpdate.jsp' starting page</title>
    
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form>
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"/>
                    <span >*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <select name="gender" id="gender">
                        <option value="1" <c:if test="${user.gender == 1 }">selected="selected"</c:if>>男</option>
                        <option value="2" <c:if test="${user.gender == 2 }">selected="selected"</c:if>>女</option>
                    </select>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="data" id="data" readonly class="Wdate" onclick="WdatePicker();" value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone" value="${user.phone }"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress" value="${user.address }"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <select id="userLei" name="userLei">
                        <option value="1" <c:if test="${user.userRole == 1 }">selected="selected"</c:if>>管理员</option>
                        <option value="2" <c:if test="${user.userRole == 2 }">selected="selected"</c:if>>经理</option>
                        <option value="3" <c:if test="${user.userRole == 3 }">selected="selected"</c:if>>普通用户</option>
                    </select>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="hidden" id="id" value="${user.id }" >
                    <input type="button" value="保存" onclick="modifyUser()" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="<%=basePath%>js/time.js"></script>
<script src="<%=basePath%>js/jquery.js"></script>
<script src="<%=basePath%>js/user.js"></script>
<script src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

</body>
</html>
